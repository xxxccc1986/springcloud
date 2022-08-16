package top.year21.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 18:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrder83 {
    public static void main(String[] args){
        SpringApplication.run(NacosOrder83.class,args);
    }
}
