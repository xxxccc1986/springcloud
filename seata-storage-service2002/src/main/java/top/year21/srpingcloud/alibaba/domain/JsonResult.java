package top.year21.srpingcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 23:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<E> {
    private int code;
    private String message;
    private E data;
}
