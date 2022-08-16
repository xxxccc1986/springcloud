package top.year21.springcloud.contoller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.year21.springcloud.service.PaymentFeignService;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 22:28
 */
@RestController
@RequestMapping("/hystrix")
//@DefaultProperties(defaultFallback = "getPaymentBadDefaultHandleMethod") //表示这个类使用了全局降级方法
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/ok/{id}")
    public String getPaymentOk(@PathVariable("id") Integer id){
        return paymentFeignService.paymentOk(id);
    }


    @GetMapping("/bad/{id}")
//    @HystrixCommand(fallbackMethod = "getPaymentBadHandleMethod") //这个表示降级方法指定为fallbackMethod的方法
//    @HystrixCommand //当这个注解没有设置任何值时表示降级使用的是全局降级方法
    public String getPaymentBad(@PathVariable("id") Integer id){
        return paymentFeignService.paymentBad(id);
    }

    public String getPaymentBadHandleMethod(@PathVariable("id")Integer id){
        return "这里是消费者80，对方支付系统繁忙，请过一会再尝试，谢谢！你的请求id是：" + id;
    }

    public String getPaymentBadDefaultHandleMethod(){
        return "这里全局的降级处理方法";
    }
}
