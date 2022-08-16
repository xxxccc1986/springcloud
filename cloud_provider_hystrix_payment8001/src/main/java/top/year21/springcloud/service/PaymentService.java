package top.year21.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 21:51
 */
@Service
public class PaymentService {

    public String paymentInfo_Is_OK(Integer id){
        return "当前处理的线程名字：" + Thread.currentThread().getName() + "\t,paymentInfo_Is_OK且id是:" + id;
    }

    //设置服务降级的回调方法名和该业务处理超时时间
    @HystrixCommand(fallbackMethod = "paymentInfo_Is_Bad_HandleMethod",commandProperties = {
            //设置命令超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Is_Bad(Integer id) {
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return "当前处理的线程名字：" + Thread.currentThread().getName() + "\t,paymentInfo_Is_Bad且id是:" + id;
    }

    //用于服务降级的fallback方法
    public String paymentInfo_Is_Bad_HandleMethod(Integer id) {
        return "当前处理的线程名字：" + Thread.currentThread().getName() +
                "8001系统连接超时或抛异常触发服务降级的fallback方法,参数id是：" + id;
    }


    /*
        ==============================分界线========================
                        往上为服务降级内容，往下为服务熔断内容
     */

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            // 请求次数
            //该属性用来设置在演动时间窗中，断路器熔断的最小请求数。例如,默认该值为20的时候,
            //如果滑动时间窗(默认10秒)内仅收到19个请求,即使这19个请求都失败了,断路器也不会打开。
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "20"),
            //该属性用来设置当断路器打开之后的休眠时间窗。休眠时间窗结束之后,
            //会将断路器置为“半开"状态，尝试熔断的请求命令，如果依然失败就将断路器继续设置为“打开"状态,
            //如果成功就设置为“关闭"状态。
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            // 失败率达到多少后跳闸，以这里为例10次请求超过6次失败就会熔断
            //该属性用来设置在模动时间窗中，表示在滑动时间窗中，如果错误请求数的百分比超过60,
            //就把断路器设置为“打开"状态，否则就设置为“关闭"状态。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，id: " +id;
    }
}
