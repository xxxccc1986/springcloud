package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 21:38
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class CloudProviderHystrixPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8001.class,args);
    }
}
