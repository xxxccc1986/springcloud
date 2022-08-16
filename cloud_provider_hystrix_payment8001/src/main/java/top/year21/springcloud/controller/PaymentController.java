package top.year21.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.year21.springcloud.service.PaymentService;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 21:56
 */
@RestController
@RequestMapping("/hystrix")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Is_OK(id);
    }

    @GetMapping("/payment/bad/{id}")
    public String paymentBad(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Is_Bad(id);
    }

    /*
        ==============================分界线========================
                        往上为服务降级内容，往下为服务熔断内容
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }

}
