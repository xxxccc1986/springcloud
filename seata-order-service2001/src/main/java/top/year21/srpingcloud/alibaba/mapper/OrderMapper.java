package top.year21.srpingcloud.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.year21.srpingcloud.alibaba.domain.Order;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 23:07
 */
@Mapper
public interface OrderMapper {
    //新建订单
    public int createOrder(Order order);

    //修改订单状态
    public int updateOrderStatus(@Param("userId") Integer userId);
}
