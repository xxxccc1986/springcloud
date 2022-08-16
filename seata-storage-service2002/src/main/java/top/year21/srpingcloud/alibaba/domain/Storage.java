package top.year21.srpingcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 21:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Integer id;
    private Integer productId;
    private Integer count;
    private Integer used;
    private Integer residue;
}
