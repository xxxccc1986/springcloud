package top.year21.srpingcloud.alibaba.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.year21.srpingcloud.alibaba.mapper.AccountMapper;
import top.year21.srpingcloud.alibaba.service.AccountService;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 21:37
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired(required = false)
    private AccountMapper accountMapper;
    @Override
    public int decreaseAccount(Integer userId, BigDecimal money) {
        log.info("**********开始执行扣钱操作********");
//        try { TimeUnit.MINUTES.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        int result = accountMapper.decreaseAccount(userId, money);
        log.info("**********扣钱操作完成********");
        return result;
    }
}
