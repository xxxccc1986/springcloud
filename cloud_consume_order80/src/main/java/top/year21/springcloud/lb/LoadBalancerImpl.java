package top.year21.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 14:24
 */
@Component
public class LoadBalancerImpl implements LoadBalancer{
    //原子Integer类，初始化值为0
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //用于获取当前是第几次请求
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current,next));
        System.out.println("当前next值为：" + next);
        return next;
    }

    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> instances) {
        //获得instances列表中可用服务提供者的下标位置
        int index = getAndIncrement() % instances.size();
        //返回可用的服务提供者
        return instances.get(index);
    }
}
