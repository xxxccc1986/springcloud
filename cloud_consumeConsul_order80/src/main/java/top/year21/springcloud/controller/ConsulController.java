package top.year21.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 0:49
 */
@RestController
@RequestMapping("/consume")
public class ConsulController {
    @Autowired
    private RestTemplate restTemplate;
    private static final String PAYMENT_URL = "http://consul-provider-payment"; //单机版consul

    @GetMapping("/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/consul",String.class);
        return result;
    }
}
