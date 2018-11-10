package com.gt.esp.model.constant;

import java.io.Serializable;

/**
 * 创建时间：2018年/11月/10日
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：IExceptionEnum
 * 描述：异常枚举统一接口
 */
public interface IExceptionEnum extends Serializable {
    /**
     * 获取错误码
     *
     * @return 返回错误码
     */
    String getCode();

    /**
     * 获取错误信息
     *
     * @return 获取错误信息
     */
    String getMessage();

    /**
     * 设置错误信息
     *
     * @param message 设置错误信息
     */
    void setMessage(String message);


}
