package top.year21.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;
import top.year21.springcloud.lb.LoadBalancer;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/4 23:54
 */
@RestController
@RequestMapping("/consume")
@Slf4j
public class ConsumeOrderController {

    @Autowired
    private RestTemplate restTemplate;
//    private static final String PAYMENT_URL = "http://localhost:8001"; 单机版微服务提供者
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; //集群版微服务提供者

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/createPayment")
    public JsonResult<Payment> createPayment(Payment payment){
        /*
        (url,requestMap,ResponseBean.class)这三个参数分别代表
        Rest请求地址、请求参数、Http响应被转换成的对象类型
         */
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add",payment,JsonResult.class);
    }

    @GetMapping("/queryPayment/{id}")
    public JsonResult<Payment> queryPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/query/" + id,JsonResult.class);
    }

    @GetMapping("/lb")
    public String getPaymentUrl(){
        //获取所有可用的服务提供者列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        //获取是真正提供服务的那个实例
        ServiceInstance instance = loadBalancer.serviceInstance(instances);
        //获取访问接口地址
        URI uri = instance.getUri();
        //进行访问
        return restTemplate.getForObject(uri + "/payment/lb",String.class);
    }


    // ====================> zipkin+sleuth
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin", String.class);
        return result;
    }

}
