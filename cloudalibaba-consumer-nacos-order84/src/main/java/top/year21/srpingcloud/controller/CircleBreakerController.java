package top.year21.srpingcloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;
import top.year21.srpingcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 23:33
 */
@RestController
@RequestMapping("/consume")
public class CircleBreakerController {
    @Resource
    private RestTemplate restTemplate;

    public static final String SERVER_URL = "http://nacos-payment-provider";

    @GetMapping("/fallback/{id}")
    //没有任何配置的情况
//    @SentinelResource("fallback")
    //配置fallback的情况,只负责处理业务异常
//    @SentinelResource(value = "fallback",fallback = "defaultFallbackMethod")
    //配置blockHandler的情况,只负责处理sentinel控制台配置违规
//    @SentinelResource(value = "fallback",blockHandler = "defaultBlockHandlerMethod")
    //既配置fallback又配置blockHandler的情况,exceptionsToIgnore属性表示假如报该异常，fallback降级方法不处理，没有降级效果
    @SentinelResource(value = "fallback",fallback = "defaultFallbackMethod",blockHandler = "defaultBlockHandlerMethod",
                        exceptionsToIgnore = {IllegalArgumentException.class})
    public JsonResult<Payment> getTest(@PathVariable("id") Integer id){
        if (id == 4){
            throw new IllegalArgumentException("非法参数");
        }else if (id == 5){
            throw new NullPointerException("无该id记录，空指针异常");
        }
        return restTemplate.getForObject(SERVER_URL + "/paymentSQL/" + id,JsonResult.class);
    }

    //定义fallback方法
    public JsonResult defaultFallbackMethod(@PathVariable("id")Integer id,Throwable e){
        Payment payment = new Payment(id,"null");
        return new JsonResult<>(444,"查询的id是：" + id + ",异常信息:" + e.getMessage(),payment);
    }

    //定义defaultBlockHandlerMethod方法
    public JsonResult defaultBlockHandlerMethod(@PathVariable("id")Integer id, BlockException b){
        Payment payment = new Payment(id,"null");
        return new JsonResult<>(445,"查询的id是：" + id + ",sentinel限流:" + b.getMessage() ,payment);
    }

    /* ==================分界线，往上为ribbon系列，往下为openFeign系列============= */
    @Resource
    private PaymentService paymentService;

    @GetMapping("/openFeign/{id}")
    public JsonResult getPaymentByOpenFeign(@PathVariable("id") Integer id){
        return paymentService.getPayment(id);
    }

}
