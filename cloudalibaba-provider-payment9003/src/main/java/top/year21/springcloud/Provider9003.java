package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 23:26
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Provider9003 {
    public static void main(String[] args){
        SpringApplication.run(Provider9003.class,args);
    }
}
