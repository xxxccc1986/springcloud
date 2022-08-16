package top.year21.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 18:50
 */
@RestController
@RequestMapping("/nacos")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/getport")
    public String getServerPort(){
        return restTemplate.getForObject(serverUrl+"/nacos/payment/info",String.class);
    }
}
