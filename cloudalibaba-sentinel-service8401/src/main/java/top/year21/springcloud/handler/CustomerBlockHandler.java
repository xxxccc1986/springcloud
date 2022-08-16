package top.year21.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;
import top.year21.springcloud.common.JsonResult;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 自定义限流处理类,用于自定义限流处理逻辑
 * @date 2022/8/13 22:37
 */
@Component
public class CustomerBlockHandler {
    //自定义处理方法
    public static JsonResult customerHandleException(BlockException exception){
        return new JsonResult(411,"自定义的限流处理信息......CustomerBlockHandler");
    }
}
