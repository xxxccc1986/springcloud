package top.year21.srpingcloud.alibaba.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.year21.srpingcloud.alibaba.domain.Order;
import top.year21.srpingcloud.alibaba.mapper.OrderMapper;
import top.year21.srpingcloud.alibaba.service.AccountService;
import top.year21.srpingcloud.alibaba.service.OrderService;
import top.year21.srpingcloud.alibaba.service.StorageService;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 23:29
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    private OrderMapper orderMapper;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;


    @Override
    /*@GlobalTransactional表示开启全局事务管理，
    name属性值可以随便设置，保证唯一性即可。
    rollbackFor属性为Exception.class表示出现Exception异常及其Exception子类的异常业务都会进回滚
    */
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        //先创建订单
        log.info("-------------正在创建订单-------------");
        orderMapper.createOrder(order);

        log.info("-------------创建订单成功，订单微服务调用库存微服务，减少库存-------------");
        //订单创建成功后，减少库存
        storageService.decreaseStorage(order.getProductId(),order.getCount());

        log.info("-------------库存减少成功，订单微服务调用账户微服务，减少账户金额-------------");
        //库存减少之后，扣减用户金额
        accountService.decreaseAccount(order.getUserId(),order.getMoney());

        log.info("-------------账户金额减少成功，修改订单状态-------------");
        //扣除金额成功后，修改订单状态
        orderMapper.updateOrderStatus(order.getId());

        log.info("-------------订单状态修改成功，业务结束-------------");

    }

}
