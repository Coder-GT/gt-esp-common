package com.gt.esp.model.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * 创建时间：2018/六月/08
 *
 * @author 张政[zhang_zheng@gt.com.cn]
 * 类名：ExceptionEnum
 * 描述：ExceptionEnum
 */
@AllArgsConstructor
public enum ExceptionEnum implements IExceptionEnum {
    //------------------------------系统类------------------------------
    //region 系统类
    INVOKING_ERROR("GT-00000", "操作失败"),
    INVOKING_SUCCESS("GT-00001", "调用成功"),
    SYSTEM_FAILURE("GT-00002", "系统异常"),
    JSON_FAILURE("GT-00003", "Json 序列化对象错误"),
    METHOD_NOT_ALLOWED("GT-00004", "POST/GET 请求方式错误"),
    JSON_DATA_ERROR("GT-00005", "Json 数据格式错误"),
    UNSUPPORTED_MEDIA_TYPE("GT-00006", "请求数据类型不正确"),
    SERVICE_NOT_FOUND_ERROR("GT-00008", "不存在此接口"),
    DATABASE_FAILURE("GT-00009", "数据库调用失败"),
    INVOKING_FAILURE("GT-00010", "调用失败"),
    INPUT_FILE_FAILURE("GT-00016", "删除文件失败"),
    RUNTIME_FAILURE("GT-00017", "请求失败"),
    ENCODING_FAILURE("GT-00018", "转码出错"),
    RESPONSE_FAILURE("GT-00019", "获取响应失败"),
    EXCEL_UPLOAD_FAILURE("GT-00020", "Excel 上传失败"),
    KTR_INPUT_FAILURE("GT-00021", "ktr 文件上传失败"),
    EXCEL_INPUT_FAILURE("GT-00022", "Excel 导入失败"),
    FILE_NULL("GT-00023", "对象为空"),
    FOLDER_NOT_EXIST("GT-00024", "ThreadLocal 中没有发现当前线程所对应的 uuid 文件夹名称"),
    PREVIEW_UNIQUE_IS_NONE("GT-00025", "预览参数文件 ID 为空"),
    PREVIEW_REMOTE_SERVER_EXCEPTION("GT-00026", "预览服务异常"),
    EXCEL_DOWN_FAILURE("GT-00027", "模板下载失败"),
    SYSTEM_DICT_INVALID_ERROR("GT-00028", "数据字典码无效"),
    DOWN_FAILURE("GT-00029", "下载失败"),
    DATABASE_FIELD_NOT_EXIST("GT-00030", "数据库表字段缺失"),
    PROGRESS_NOT_EXIST("GT-00031", "后台任务不存在"),
    //endregion

    //--------------------------------获取角色实例-----------------------------
    //region 获取角色实例
    USER_ROLE_FAILURE("GT-02000", "获取用户角色实例失败"),
    //endregion

    //---------------------接口异常-------------
    //region 接口异常
    PARAM_MISSING("GT-01100", "参数缺失"),
    SAVE_EXCEPTION("GT-01101", "添加失败"),
    DELETE_EXCEPTION("GT-01102", "删除失败"),
    UPDATE_EXCEPTION("GT-11003", "修改失败"),
    DATA_NOT_EXIST("GT-01104", "数据不存在"),
    FIND_EXCEPTION("GT-01105", "查找失败"),
    TOKEN_NULL("GT-01106", "token为空"),
    PARAMETER_NULL("GT-01107", "表名或数据库名为空"),
    PARAM_NULL("GT-01108", "参数为空"),
    SALESMAN_CAN_APPLY("GT-01109", "业务员才能申请"),
    SALESMAN_CAN_UPDATE("GT-01110", "业务员才能修改"),
    REQUIRED_FIELD_CHECK("GT-01111", "请填写所有必填项"),
    SERVE_TEMP_CHAN_NULL("GT-01112", "服务模板变更记录为空"),
    CON_ID_NULL("GT-01113", "商务合同id为空"),
    EMP_NUM_IS_ERROR("GT-11001", "当前页码内容不正确"),
    //endregion

    //------------------------------主键ID生成-------------------------------
    //region 主键ID生成
    CLOCK_FALLBACK("GT-07000", "时钟回退异常"),
    //endregion

    //------------------------------文件模板功能异常-------------------------------
    MONGO_TEMPLATE_FILE_TYPE_NULL("GT-06902", "模板 - 模板类型缺失"),
    ;

    @Getter
    private String code;
    @Setter
    private String message;

    @Override
    public String getMessage() {
        return isNull(this.message) ? EMPTY : this.message;
    }

}
