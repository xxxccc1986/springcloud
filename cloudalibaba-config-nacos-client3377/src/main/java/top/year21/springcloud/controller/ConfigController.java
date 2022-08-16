package top.year21.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 21:40
 */
@RestController
@RequestMapping("/nacos")
@RefreshScope //支持Nacos的动态刷新功能,同个SpringCloud原生注解@RefreshScope实现配置自动更新
public class ConfigController {
    @Value("${config.info}")
    private String info;

    @GetMapping("/config")
    public String getInfo(){
        return "这是从nacos配置中心获取的配置信息内容：" + info;
    }
}
