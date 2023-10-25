package com.ntrcb.common.util;

import org.springframework.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

public class ToolUtil {

    /**
     * description: 使用url 下载远程文件
     * @param urlPath  --- url资源
     * @param targetDirectory --- 目标文件夹
     * @throws Exception
     * @return void
     * @version v1.0
     * @author w
     * @date 2019年9月3日 下午8:29:01
     */
    public static String download(String urlPath , String targetDirectory,String fileName) throws Exception {
        // 解决url中可能有中文情况
        System.out.println("url:"+ urlPath);
        URL url = new URL(urlPath);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setConnectTimeout(3000);
        // 设置 User-Agent 避免被拦截
        http.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
        String contentType = http.getContentType();
        System.out.println("contentType: "+ contentType);
        // 获取文件大小
        long length = http.getContentLengthLong();
        System.out.println("文件大小："+(length / 1024)+"KB");
        // 获取文件名
        if(StringUtils.isEmpty(fileName)){
            fileName = getFileName(http , urlPath);
        }
        InputStream inputStream = http.getInputStream();
        byte[] buff = new byte[1024*10];
        OutputStream out = new FileOutputStream(new File(targetDirectory,fileName));
        int len ;
        int count = 0; // 计数
        while((len = inputStream.read(buff)) != -1) {
            out.write(buff, 0, len);
            out.flush();
            ++count ;
        }
        System.out.println("count:"+ count);
        // 关闭资源
        out.close();
        inputStream.close();
        http.disconnect();
        return fileName;
    }

    /**
     * description: 获取文件名
     * @param http
     * @param urlPath
     * @throws UnsupportedEncodingException
     * @return String
     * @version v1.0
     * @author w
     * @date 2019年9月3日 下午8:25:55
     */
    private static String getFileName(HttpURLConnection http , String urlPath) throws UnsupportedEncodingException {
        String headerField = http.getHeaderField("Content-Disposition");
        String fileName = null ;
        if(null != headerField) {
            String decode = URLDecoder.decode(headerField, "UTF-8");
            fileName = decode.split(";")[1].split("=")[1].replaceAll("\"", "");
            System.out.println("文件名是： "+ fileName);
        }
        if(null == fileName) {
            // 尝试从url中获取文件名
            String[] arr  = urlPath.split("/");
            fileName = arr[arr.length - 1];
            System.out.println("url中获取文件名："+ fileName);
        }
        return fileName;
    }

}
