package top.year21.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;

import java.util.HashMap;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 23:26
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static
    {
        hashMap.put(1L,new Payment(1,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L,new Payment(2,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L,new Payment(3,"6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public JsonResult<Payment> paymentSQL(@PathVariable("id") Long id)
    {
        Payment payment = hashMap.get(id);
        JsonResult<Payment> result = new JsonResult(200,"from mysql,serverPort:  "+serverPort,payment);
        return result;
    }
}
