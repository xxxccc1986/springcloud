package top.year21.srpingcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.year21.srpingcloud.alibaba.domain.JsonResult;
import top.year21.srpingcloud.alibaba.service.StorageService;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 21:23
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decreaseStorage")
    public JsonResult decreaseStorage(@RequestParam("productId") Integer productId,
                                              @RequestParam("count") Integer count){
        int result = storageService.decreaseStorage(productId, count);
        return new JsonResult<>(200,"库存减少成功，已减少：" + count,result);
    }
}
