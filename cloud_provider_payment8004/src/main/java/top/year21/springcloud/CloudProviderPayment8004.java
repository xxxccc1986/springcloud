package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 0:13
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class CloudProviderPayment8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8004.class,args);
    }
}
