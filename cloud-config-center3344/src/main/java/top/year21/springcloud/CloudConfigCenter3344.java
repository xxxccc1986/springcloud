package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/9 21:31
 */
@SpringBootApplication
@EnableConfigServer //开启配置中心的注解
public class CloudConfigCenter3344 {
    public static void main(String[] args){
        SpringApplication.run(CloudConfigCenter3344.class,args);
    }
}
