package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/8 18:55
 */
@SpringBootApplication
@EnableHystrixDashboard //开启hystrix的图形化
public class CloudConsumeHystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumeHystrixDashboard9001.class,args);
}
}
