package top.year21.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 14:22
 */
public interface LoadBalancer {
    //获取集群中的可用服务提供者的数量
    ServiceInstance serviceInstance(List<ServiceInstance> instances);
}
