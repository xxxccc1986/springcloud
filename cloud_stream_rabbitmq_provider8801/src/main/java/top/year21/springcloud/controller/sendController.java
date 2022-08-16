package top.year21.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.year21.springcloud.service.IMessageServiceProvider;

import javax.annotation.Resource;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 21:42
 */
@RestController
@RequestMapping("/stream")
public class sendController {

    @Resource
    private IMessageServiceProvider messageServiceProvider;

    @GetMapping("/send")
    public String sendMSG(){
        String msg = messageServiceProvider.sendMsg();
        return msg;
    }
}
