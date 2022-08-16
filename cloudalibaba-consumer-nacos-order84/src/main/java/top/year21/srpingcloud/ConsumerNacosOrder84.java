package top.year21.srpingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 23:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerNacosOrder84 {
    public static void main(String[] args){
        SpringApplication.run(ConsumerNacosOrder84.class,args);
    }
}
