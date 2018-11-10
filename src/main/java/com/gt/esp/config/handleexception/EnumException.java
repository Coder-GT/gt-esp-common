package com.gt.esp.config.handleexception;

import com.gt.esp.model.constant.IExceptionEnum;
import lombok.Getter;
import lombok.Setter;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * 创建时间：2018年/11月/10日
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：EnumException
 * 描述：全局异常实体
 */
@Setter
class EnumException extends RuntimeException {

    /**
     * 错误的枚举返回
     */
    @Getter
    private final IExceptionEnum responseEnum;

    /**
     * 补充错误信息
     */
    private final String suffix;

    EnumException(IExceptionEnum responseEnum) {
        this.responseEnum = responseEnum;
        this.suffix = EMPTY;
    }

    EnumException(IExceptionEnum responseEnum, String suffix) {
        super();
        this.responseEnum = responseEnum;
        this.suffix = suffix;
    }

    String getSuffix() {
        return isNull(this.suffix) ? EMPTY : this.suffix;
    }

}
