package top.year21.srpingcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.year21.srpingcloud.alibaba.domain.JsonResult;

import java.math.BigDecimal;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 23:30
 */
@Component
@FeignClient("seata-account-service") //通过@FeignClient远程调用seata-account-service微服务的rest接口请求
public interface AccountService {
    //减少账户金额
    @PostMapping("/account/decreaseAccount")
    public JsonResult decreaseAccount(@RequestParam("userId") Integer userId,
                                              @RequestParam("money") BigDecimal money);
}
