package top.year21.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 18:27
 */
@SpringBootApplication
@EnableDiscoveryClient //让该服务在注册中心注册和从注册中心获取其他服务
public class Payment9001 {
    public static void main(String[] args){
        SpringApplication.run(Payment9001.class,args);
    }
}
