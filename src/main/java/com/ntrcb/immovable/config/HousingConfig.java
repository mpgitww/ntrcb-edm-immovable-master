package com.ntrcb.immovable.config;

import com.finstone.house.iface.ws.client.FrameInvokeServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: 公积金网贷中心配置
 * @Date: create in 2022/9/8 14:17
 */
@Configuration
public class HousingConfig {
    @Value("${housing.url}")
    String housing_url;
    @Bean("client")
    public FrameInvokeServiceClient getClient(){
        FrameInvokeServiceClient client = new FrameInvokeServiceClient();
        client.setUrl(housing_url);
        client.setEncode("UTF-8");
        return client;
    }
}
