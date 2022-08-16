package top.year21.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 数据表对应实体类
 * @date 2022/8/4 22:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private Integer id;
    private String serial;
}
