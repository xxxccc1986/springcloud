package top.year21.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 18:28
 */
@RestController
@RequestMapping("/nacos")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/info")
    public String getPort(){
        return "这里是nacos server服务注册中心，提供服务的端口号为："  + port;
    }
}

