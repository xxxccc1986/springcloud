package top.year21.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 0:18
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/zk")
    public String paymentZK(){
        return "springcloud with zookeeper:" + port + "\t" + UUID.randomUUID().toString();
    }
}
