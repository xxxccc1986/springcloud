package top.year21.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/4 23:59
 */
@Configuration
public class ApplicationContextConfig {

    @LoadBalanced //开启RestTemplate的负载均衡
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
