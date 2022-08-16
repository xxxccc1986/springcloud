package top.year21.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 16:49
 */
@SpringBootApplication
@EnableFeignClients  //标明使用feign，激活并开启
public class CloudConsumeFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumeFeignOrder80.class,args);
    }
}
