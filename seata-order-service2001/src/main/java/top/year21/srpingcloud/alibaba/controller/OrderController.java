package top.year21.srpingcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.year21.srpingcloud.alibaba.domain.JsonResult;
import top.year21.srpingcloud.alibaba.domain.Order;
import top.year21.srpingcloud.alibaba.service.OrderService;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 0:01
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/seata/consume")
    public JsonResult createOrder(Order order){
        orderService.createOrder(order);
        return new JsonResult(200,"订单创建成功",null);
    }

}
