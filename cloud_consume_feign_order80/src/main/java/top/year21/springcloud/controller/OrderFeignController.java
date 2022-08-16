package top.year21.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;
import top.year21.springcloud.service.PaymentFeignService;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 16:59
 */
@RestController
@RequestMapping("/feign")
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/query/{id}")
    public JsonResult<Payment> getPaymentById(@PathVariable("id") Integer id){
        return paymentFeignService.queryPayment(id);
    }
}
