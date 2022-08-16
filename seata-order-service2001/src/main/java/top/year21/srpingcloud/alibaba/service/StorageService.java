package top.year21.srpingcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.year21.srpingcloud.alibaba.domain.JsonResult;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 23:30
 */
@Component
@FeignClient("seata-storage-service") //通过@FeignClient远程调用seata-storage-service微服务的rest接口请求
public interface StorageService {
    //减少库存
    @PostMapping("/storage/decreaseStorage")
    public JsonResult decreaseStorage(@RequestParam("productId") Integer productId,
                                              @RequestParam("count") Integer count);
}
