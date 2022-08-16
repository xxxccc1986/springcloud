package top.year21.springcloud.service;

import top.year21.springcloud.entity.Payment;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/4 22:42
 */
public interface PaymentService {
    public int addPayment(Payment payment);

    public Payment queryById(Integer id);

}
