package top.year21.springcloud.service;

import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Component;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 用于feign调用服务发生异常，hystrix执行的需要的回退类
 * @date 2022/8/8 1:00
 */
@Component
public class FallBackMethod implements PaymentFeignService{
    @Override
    public String paymentOk(Integer id) {
        return "paymentOk is Not OK";
    }

    @Override
    public String paymentBad(Integer id) {
        return "paymentBad is Not OK";
    }
}
