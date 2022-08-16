package top.year21.srpingcloud.alibaba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.year21.srpingcloud.alibaba.mapper.StorageMapper;
import top.year21.srpingcloud.alibaba.service.StorageService;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 21:21
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;

    @Override
    public int decreaseStorage(Integer productId, Integer count) {
        return storageMapper.decreaseStoage(count,productId);
    }
}
