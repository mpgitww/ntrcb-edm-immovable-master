package com.ntrcb.common.util;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.ntrcb.common.config.properties.S3Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

/**
 * @author 01061698
 * @Description: S3工具类
 * @date 2021/12/30 11:26
 */
@Slf4j
//@Component
public class S3Util {
    @Autowired
    private AmazonS3 client;

    @Resource
    private S3Properties properties;

    /**
     * 判断桶是否存在
     *
     * @param bucketName 桶名
     * @return
     */
    public boolean existBucket(String bucketName) {
        try {
            return client.doesBucketExistV2(bucketName);
        } catch (AmazonServiceException ase) {
            log.error(String.format("check bucket %s exist error", bucketName), ase);
        }
        return false;
    }

    /**
     * 创建桶
     *
     * @param bucketName 桶名
     * @return
     */
    public Bucket createBucket(String bucketName) {
        Bucket bucket = null;
        try {
            bucket = client.createBucket(bucketName);
        } catch (AmazonServiceException ase) {
            log.error(String.format("create bucket %s exist error", bucketName), ase);
        }
        return bucket;
    }

    /**
     * 上传文件
     *
     * @param bucketName
     * @param key
     * @param file
     * @return
     */
    public PutObjectResult upload(String bucketName, String key, File file) {
        if (!this.existBucket(bucketName)) {
            this.createBucket(bucketName);
        }
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.addUserMetadata("Use_test", "test");
        PutObjectRequest putRequest = new PutObjectRequest(bucketName, key, file);
        putRequest.setMetadata(metadata);
        return client.putObject(putRequest);
    }

    /**
     *
     * @param bucketName
     * @param key
     * @param file
     * @return
     * @throws IOException
     */
    public PutObjectResult upload(String bucketName, String key, MultipartFile file) throws IOException {
        if (!this.existBucket(bucketName)) {
            this.createBucket(bucketName);
        }
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.addUserMetadata("Use_test", "test");
        PutObjectRequest putRequest = new PutObjectRequest(bucketName, key, file.getInputStream(), metadata);
        return client.putObject(putRequest);
    }

    /**
     * 获取对象的元数据
     */
    public S3Object getObject(String bucketName, String key) {
        return client.getObject(new GetObjectRequest(bucketName, key));
    }

    /**
     * 获取对象输入流
     *
     * @param bucketName
     * @param key
     * @return
     */
    public S3ObjectInputStream getObjectInputStream(String bucketName, String key) {
        S3Object s3Object = this.getObject(bucketName, key);
        return s3Object.getObjectContent();
    }

    /**
     * 将对象写入输出流
     *
     * @param bucketName
     * @param key
     * @param outputStream
     * @throws IOException
     */
    public void write2OutputStream(String bucketName, String key, OutputStream outputStream) throws IOException {
        S3ObjectInputStream input = this.getObjectInputStream(bucketName, key);
        byte[] bytes = new byte[128];
        int n;
        while ((n = input.read(bytes, 0, bytes.length)) != -1) {
            outputStream.write(bytes, 0, n);
        }
        input.close();
    }

    public String getURL(String bucketName, String key, long expireTimeMillis, HttpMethod method) {
        Date expiration = new java.util.Date();
        expiration.setTime(expireTimeMillis);
        // 生成URL
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, key)
                        .withMethod(method)
                        .withExpiration(expiration);
        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    public String getURL(String key, long expTimeMillis, HttpMethod method) {
        return getURL(properties.getBucket(), key, expTimeMillis, method);
    }
}
