package top.year21.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.year21.springcloud.common.JsonResult;
import top.year21.springcloud.entity.Payment;
import top.year21.springcloud.handler.CustomerBlockHandler;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 22:12
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public JsonResult byResource() {
        return new JsonResult(200,"按资源名称限流测试OK",new Payment(1,"test"));
    }

    public JsonResult handleException(BlockException exception) {
        return new JsonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public JsonResult byUrl() {
        return new JsonResult(200,"按url限流测试OK",new Payment(2022,"serial002"));
    }


    /**
     * 自定义通用的限流处理逻辑，
     blockHandlerClass = CustomerBlockHandler.class
     blockHandler = handleException2
     上述配置：找CustomerBlockHandler类里的handleException2方法进行兜底处理
     */
    /**
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "customerHandleException")
    public JsonResult customerBlockHandler()
    {
        return new JsonResult(200,"CustomerBlockHandler全局处理方法customerHandleException");
    }
}
