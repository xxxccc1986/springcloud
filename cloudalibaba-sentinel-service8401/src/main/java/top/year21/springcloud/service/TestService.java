package top.year21.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 16:45
 */
@Service
public class TestService {
    //定义限流资源
    @SentinelResource("link")
    public String testLink(){
        return "链路模式测试成功";
    }
}
