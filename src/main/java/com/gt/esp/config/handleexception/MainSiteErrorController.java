package com.gt.esp.config.handleexception;

import com.gt.esp.model.constant.ExceptionEnum;
import com.gt.esp.model.constant.IExceptionEnum;
import com.gt.esp.util.voutils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLSyntaxErrorException;

import static com.gt.esp.util.voutils.ResultResponseUtils.error;
import static org.springframework.http.HttpStatus.OK;

/**
 * 创建时间：2018年/11月/10日
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：MainSiteErrorController
 * 描述：用来处理系统全局性异常
 */
@ResponseStatus(OK)
@RestController
@RestControllerAdvice
@Slf4j
public class MainSiteErrorController implements ErrorController {
    /**
     * 匹配 error 并处理
     */
    private static final String ERROR_PATH = '/' + "error";

    /**
     * 本方法处理 Exception 抛出异常的情况
     *
     * @param e 传递的最顶级的异常
     * @return 返回响应
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handle(Exception e) {
        if (e instanceof EnumException) {
            EnumException enumException = (EnumException) e;
            IExceptionEnum responseEnum = enumException.getResponseEnum();
            log.error("异常提示如下，CODE:{}，额外 Message:{}", responseEnum.getCode(), responseEnum.getMessage());
            return error(responseEnum, responseEnum.getMessage() + enumException.getSuffix());
        }

        log.error("异常如下行所示：", e);
        if (e instanceof HttpRequestMethodNotSupportedException) {
            return error(ExceptionEnum.METHOD_NOT_ALLOWED);
        }
        if (e instanceof HttpMessageNotReadableException) {
            return error(ExceptionEnum.JSON_DATA_ERROR);
        }
        if (e instanceof HttpMediaTypeNotSupportedException) {
            return error(ExceptionEnum.UNSUPPORTED_MEDIA_TYPE);
        }
        if (e instanceof SQLSyntaxErrorException) {
            return error(ExceptionEnum.DATABASE_FIELD_NOT_EXIST);
        }
        if (e instanceof DataAccessException) {
            return error(ExceptionEnum.DATABASE_FAILURE);
        }

        return error(ExceptionEnum.SYSTEM_FAILURE);
    }

    /**
     * 本方法处理除了 500 之外的所有异常，注意 405 错误是被 ExceptionHandler 转发调用的
     */
    @RequestMapping(ERROR_PATH)
    public ResponseResult<Object> handle(HttpServletResponse response) {
        HttpStatus i = HttpStatus.valueOf(response.getStatus());
        if (i == HttpStatus.NOT_FOUND) {
            return error(ExceptionEnum.SERVICE_NOT_FOUND_ERROR);
        }
        return error(ExceptionEnum.SYSTEM_FAILURE);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
