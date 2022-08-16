package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/5 16:39
 */
@SpringBootApplication
@EnableEurekaServer //表示这是个eureka的注册中心
public class CloudEurekaServer7007 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7007.class,args);
    }
}
