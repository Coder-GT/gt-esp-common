package com.gt.esp.util.voutils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建时间：2018/六月/08
 *
 * @author 张政[zhang_zheng@gt.com.cn]
 * 类名：ResponseResult
 * 描述：ResponseResult
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseResult<T> {
    /**
     * 响应状态码
     */
    private String code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

}
