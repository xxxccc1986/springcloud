package top.year21.srpingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/9 15:23
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGateWay9527 {
    public static void main(String[] args){
        SpringApplication.run(CloudGateWay9527.class,args);
    }
}
