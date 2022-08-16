package top.year21.springcloud.service;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 21:24
 */
//该注解的作用是告诉spring cloud stream此应用是一个消息发布者，需要绑定到中间件。
@EnableBinding(Source.class) //同时这是个复合注解，其中的@Configuration也将这个对象放入了Spring容器
public class IMessageServiceProviderImpl implements IMessageServiceProvider{

    @Resource //这里的output与application.yml配置文件中的bindings名称是对应的
    private MessageChannel output;

    @Override
    public String sendMsg() {
        String msg = UUID.randomUUID().toString();
        /* send()方法是使用消息输出通道将消息发送出去
        消息都是靠消息媒介Message对象来传递的，因此
        MessageBuilder.withPayload(msg).build()就是构建了一个Message对象
        */
        output.send(MessageBuilder.withPayload(msg).build());
        System.out.println("/* " + msg + " */");
        return null;
    }
}
