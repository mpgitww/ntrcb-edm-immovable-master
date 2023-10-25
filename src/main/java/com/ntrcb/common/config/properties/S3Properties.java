package com.ntrcb.common.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 01061698
 * @Description: s3properties
 * @date 2021/12/30 10:51
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "aws.s3-config")
public class S3Properties {
    /**
     * 访问地址
     */
    private String endPoint;
    /**
     * 访问秘钥
     */
    private String accessKey;
    /**
     * 安全秘钥
     */
    private String secretKey;
    /**
     * 桶名
     */
    private String bucket;
}
