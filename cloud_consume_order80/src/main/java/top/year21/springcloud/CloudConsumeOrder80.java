package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import top.year21.myrule.MySelfRule;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 启动类
 * @date 2022/8/4 23:43
 */
@SpringBootApplication
@EnableEurekaClient
//意思是要去访问的微服务名为CLOUD-PAYMENT-SERVICE，使用的规则是MySelfRule类中定义的规则
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class CloudConsumeOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumeOrder80.class,args);
    }
}
