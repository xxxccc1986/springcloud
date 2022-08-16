package top.year21.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;
import top.year21.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/4 22:43
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    //根据类型进行注入
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/query/{id}")
    public JsonResult<Payment> queryPayment(@PathVariable("id") Integer id){
        Payment payment = paymentService.queryById(id);
        if (payment == null){
            return new JsonResult<>(444,"没有此数据，查询的id是：" + id);
        }else {
            return new JsonResult<>(200,"查询成功,提供服务的端口号是：" + port,payment);
        }
    }

    @PostMapping("/add")
    public JsonResult<Integer> addPayment(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        log.info("插入结果：" + result);
        if (result > 0){
            return new JsonResult<>(200,"添加成功",result);
        }else {
            return new JsonResult<>(444,"添加失败");
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        //查询所有服务
        List<String> services = discoveryClient.getServices();
        //打印服务清单
        for (String e : services) {
            log.info("*****element:" + e);
        }

        //根据微服务名称查找相关的微服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return port;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "这里是paymentzipkin server fall back";
    }

}
