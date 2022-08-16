package top.year21.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;
import top.year21.springcloud.service.PaymentService;

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

    @GetMapping("/lb")
    public String getPaymentLB(){
        return port;
    }


}
