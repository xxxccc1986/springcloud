package top.year21.srpingcloud.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 21:34
 */
@Mapper
public interface AccountMapper {
    int decreaseAccount(@Param("userId") Integer userId, @Param("money") BigDecimal money);
}
