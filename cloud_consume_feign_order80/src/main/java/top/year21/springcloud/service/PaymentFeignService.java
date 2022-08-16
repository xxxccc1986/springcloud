package top.year21.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 16:52
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE") //表示找在注册中心中名字是CLOUD-PAYMENT-SERVICE微服务
public interface PaymentFeignService {

    /*
    该微服务内对应方法对外暴露的接口，这里是微服务的控制层接口，但该接口调用了其自己的业务层
    也算是间接实现了接口调用接口
     */
    @GetMapping("/payment/query/{id}")
    public JsonResult<Payment> queryPayment(@PathVariable("id") Integer id);
}
