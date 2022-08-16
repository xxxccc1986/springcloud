package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 0:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumezkOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumezkOrder80.class,args);
    }
}