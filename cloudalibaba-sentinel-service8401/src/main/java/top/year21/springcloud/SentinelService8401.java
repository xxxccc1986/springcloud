package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 0:53
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelService8401 {
    public static void main(String[] args){
        SpringApplication.run(SentinelService8401.class,args);
    }
}
