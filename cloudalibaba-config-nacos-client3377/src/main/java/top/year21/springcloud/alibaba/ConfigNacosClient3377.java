package top.year21.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 21:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigNacosClient3377 {
    public static void main(String[] args){
        SpringApplication.run(ConfigNacosClient3377.class,args);
    }
}
