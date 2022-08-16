package top.year21.srpingcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 23:30
 */
public interface AccountService {
    //减少账户金额
    public int decreaseAccount(@RequestParam("userId") Integer userId,
                                              @RequestParam("money") BigDecimal money);
}
