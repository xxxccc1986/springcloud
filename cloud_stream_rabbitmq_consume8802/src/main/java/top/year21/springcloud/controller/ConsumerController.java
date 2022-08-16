package top.year21.springcloud.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;


/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 23:20
 */
//该注解的作用是告诉spring cloud stream此应用是一个消息接收者，需要绑定到中间件。
@EnableBinding(Sink.class)   //同时这是个复合注解，其中的@Configuration也将这个对象放入了Spring容器
public class ConsumerController {

    @Value("${server.port}")
    private String port;

    @StreamListener(value = "input") //表示监听的通道名为input，与application.yml配置文件内的bindings设置的一样
//    @StreamListener(Sink.INPUT) 这个Sink.INPUT枚举对象的值和上面input是一样的
    public void input(Message<String> msg){
        System.out.println("消费者1接收到的消息是：" + msg.getPayload() + "\t" + port);
    }
}
