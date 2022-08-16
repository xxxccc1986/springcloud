package top.year21.srpingcloud.alibaba.service;


import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 23:30
 */
public interface StorageService {
    //减少库存
    public int decreaseStorage(@RequestParam("productId") Integer productId,
                                              @RequestParam("count") Integer count);
}
