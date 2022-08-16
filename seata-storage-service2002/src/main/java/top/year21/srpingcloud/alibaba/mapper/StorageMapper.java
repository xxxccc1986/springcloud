package top.year21.srpingcloud.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 21:15
 */
@Mapper
public interface StorageMapper {
    int decreaseStoage(@Param("count") Integer count,@Param("productId")Integer productId);
}
