package top.year21.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 规则配置类
 * @date 2022/8/6 17:41
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule iRule(){
        //定义为随机规则
        return new RandomRule();
    }
}
