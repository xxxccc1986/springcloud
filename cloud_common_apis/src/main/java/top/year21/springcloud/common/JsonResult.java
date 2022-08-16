package top.year21.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 工具类返回数据给前端
 * @date 2022/8/4 22:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<E> {
    private Integer status;
    private String message;
    private E data;

    public JsonResult(Integer status,String message){
        this.status = status;
        this.message = message;
    }

}
