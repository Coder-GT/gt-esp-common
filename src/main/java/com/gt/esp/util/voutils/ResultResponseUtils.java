package com.gt.esp.util.voutils;


import com.gt.esp.model.constant.ExceptionEnum;
import com.gt.esp.model.constant.IExceptionEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * 创建时间：2018/六月/08
 *
 * @author 张政[zhang_zheng@gt.com.cn]
 * 类名：ResultResponseUtils
 * 描述：前端返回 vo 的统一工具处理
 */
public class ResultResponseUtils {
    private ResultResponseUtils() {
    }

    private static ResponseResult<Object> success(IExceptionEnum code,
                                                  Object data) {
        return new ResponseResult<>(code.getCode(), code.getMessage(), data);
    }

    private static ResponseResult<Object> error(IExceptionEnum code,
                                                String errorMessage,
                                                Object data) {
        if (StringUtils.isBlank(errorMessage)) {
            errorMessage = code.getMessage();
        }
        return new ResponseResult<>(code.getCode(), errorMessage, data);
    }

    /**
     * 仅仅为操作成功，无须任何自定义信息时，默认返回 {@link ExceptionEnum#INVOKING_SUCCESS}
     *
     * @return ResponseResult 返回状态为 {@link ExceptionEnum#INVOKING_SUCCESS}
     */
    public static ResponseResult<Object> success() {
        return success(ExceptionEnum.INVOKING_SUCCESS, null);
    }

    /**
     * 仅仅为操作成功，并返回数据，默认返回 {@link ExceptionEnum#INVOKING_SUCCESS}
     *
     * @param data 需要返回的数据 data
     * @return ResponseResult 返回状态为 {@link ExceptionEnum#INVOKING_SUCCESS} 数据为传入的 data
     */
    public static ResponseResult<Object> success(Object data) {
        return success(ExceptionEnum.INVOKING_SUCCESS, data);
    }

    /**
     * 错误的时候传递的给前端的信息
     *
     * @param code {@link ExceptionEnum} 的枚举状态码
     * @return ResponseResult<Object> 传递给前端的信息，返回的消息自动从 {@link ExceptionEnum} 获取，返回对象为 null
     */
    public static ResponseResult<Object> error(IExceptionEnum code) {
        return error(code, code.getMessage(), null);
    }

    /**
     * 错误的时候传递的给前端的信息，并返回数据
     *
     * @param code {@link ExceptionEnum} 的枚举状态码
     * @param data 需要返回的数据 data
     * @return ResponseResult<Object> 传递给前端的信息，返回的消息自动从 {@link ExceptionEnum} 获取，返回对象为 null
     */
    public static ResponseResult<Object> error(IExceptionEnum code,
                                               Object data) {
        return error(code, code.getMessage(), data);
    }

    /**
     * 错误的时候传递的给前端的信息
     *
     * @param code         {@link ExceptionEnum} 的枚举状态码
     * @param errorMessage 如果为空则自动获取 {@link ExceptionEnum} 中的信息
     * @return ResponseResult<Object> 传递给前端的信息
     */
    public static ResponseResult<Object> error(IExceptionEnum code,
                                               String errorMessage) {
        return error(code, errorMessage, null);
    }

}
