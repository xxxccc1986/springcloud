package top.year21.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 22:25
 */
@Component
//value属性是微服务的名称，fallback属性是指定回调的类
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT",fallback = FallBackMethod.class)
//@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {

    @GetMapping("/hystrix/payment/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/payment/bad/{id}")
    public String paymentBad(@PathVariable("id") Integer id);
}
