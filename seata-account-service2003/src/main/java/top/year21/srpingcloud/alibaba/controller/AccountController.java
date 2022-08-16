package top.year21.srpingcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.year21.srpingcloud.alibaba.domain.JsonResult;
import top.year21.srpingcloud.alibaba.service.AccountService;

import java.math.BigDecimal;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 21:37
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/decreaseAccount")
    public JsonResult decreaseAccount(@RequestParam("userId") Integer userId,
                                      @RequestParam("money") BigDecimal money){
        int result = accountService.decreaseAccount(userId, money);
        return new JsonResult(200,"金额扣取成功，是：" + money,result);
    }
}
