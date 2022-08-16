package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 22:23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix //开启Hystrix
public class CloudConsumeFeignHystrixOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumeFeignHystrixOrder80.class,args);
    }
}
