package top.year21.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.year21.springcloud.entity.Payment;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/4 22:14
 */
@Mapper
public interface PaymentMapper {

    public int create(Payment payment);

    public Payment queryPaymentById(@Param("id") Integer id);

}
