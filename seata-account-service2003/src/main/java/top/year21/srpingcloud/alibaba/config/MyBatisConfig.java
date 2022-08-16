package top.year21.srpingcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 16:55
 */
@Configuration
@MapperScan("top.year21.srpingcloud.alibaba.mapper")
public class MyBatisConfig {
}
