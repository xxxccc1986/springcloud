package top.year21.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.year21.springcloud.dao.PaymentMapper;
import top.year21.springcloud.entity.Payment;
import top.year21.springcloud.service.PaymentService;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/4 22:42
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public int addPayment(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment queryById(Integer id) {
        return paymentMapper.queryPaymentById(id);
    }
}
