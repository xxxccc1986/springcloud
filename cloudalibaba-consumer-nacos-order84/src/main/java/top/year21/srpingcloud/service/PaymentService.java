package top.year21.srpingcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;
import top.year21.srpingcloud.common.FallbackClass;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 16:30
 */
@Component
@FeignClient(value = "nacos-payment-provider",fallback = FallbackClass.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public JsonResult<Payment> getPayment(@PathVariable("id") Integer id);
}
