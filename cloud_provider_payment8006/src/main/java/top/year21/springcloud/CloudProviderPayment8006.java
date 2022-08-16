package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 15:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment8006 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8006.class,args);
    }
}
