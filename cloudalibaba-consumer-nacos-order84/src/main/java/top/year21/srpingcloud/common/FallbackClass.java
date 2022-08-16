package top.year21.srpingcloud.common;

import org.springframework.stereotype.Component;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;
import top.year21.srpingcloud.service.PaymentService;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 16:31
 */
@Component
public class FallbackClass implements PaymentService {
    @Override
    public JsonResult<Payment> getPayment(Integer id) {
        Payment payment = new Payment(id, "null");
        return new JsonResult<>(4500,"服务降级返回，查无此用户，id是：" + id,payment);
    }
}
