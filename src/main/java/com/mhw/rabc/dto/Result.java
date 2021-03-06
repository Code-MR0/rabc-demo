package com.mhw.rabc.dto;

import com.mhw.rabc.enums.CommonReturnEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @className: Result
 * @description: 公共返回对象封装
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Data
@ApiModel(value = "返回对象封装", description = "返回对象封装")
@SuppressWarnings("all")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "返回码", required = true)
    private int code;

    @ApiModelProperty(notes = "返回数据")
    private T data;

    @ApiModelProperty(notes = "返回信息", required = true)
    private String msg;

    public Result() {

    }

    /**
     * 布尔值判断返回
     *
     * @return : Result<T>
     */
    public static <T> Result<T> check(Boolean flag) {
        if (flag) {
            return success();
        }
        return failed();
    }

    /**
     * null判断返回
     *
     * @return : Result<T>
     */
    public static <T> Result<T> check(T flag) {
        if (flag != null) {
            return success(flag);
        }
        return failed();
    }


    /**
     * 成功返回, 不指定参数
     *
     * @return : Result<T>
     */
    public static <T> Result<T> success() {
        return restResult(null, CommonReturnEnum.SUCCESS.getCode(), CommonReturnEnum.SUCCESS.getName());
    }

    /**
     * 成功返回，指定msg
     *
     * @param msg
     * @return : Result<T>
     */
    public static <T> Result<T> success(String msg) {
        return restResult(null, CommonReturnEnum.SUCCESS.getCode(), msg);
    }

    /**
     * 成功返回，指定对象
     *
     * @param data
     * @return : Result<T>
     */
    public static <T> Result<T> success(T data) {
        return restResult(data, CommonReturnEnum.SUCCESS.getCode(), CommonReturnEnum.SUCCESS.getName());
    }

    /**
     * 成功返回，指定msg,data
     *
     * @param msg
     * @param data
     * @return : Result<T>
     */
    public static <T> Result<T> success(String msg, T data) {
        return restResult(data, CommonReturnEnum.SUCCESS.getCode(), msg);
    }

    /**
     * 成功返回，指定code,msg,data
     *
     * @param code
     * @param msg
     * @param data
     * @return : Result<T>
     */
    public static <T> Result<T> success(int code, String msg, T data) {
        return restResult(data, code, msg);
    }


    /**
     * 失败返回
     *
     * @return : Result<T>
     */
    public static <T> Result<T> failed() {
        return restResult(null, CommonReturnEnum.FAILED.getCode(), CommonReturnEnum.FAILED.getName());
    }

    /**
     * 失败返回，指定msg
     *
     * @param msg
     * @return : Result<T>
     */
    public static <T> Result<T> failed(String msg) {
        return restResult(null, CommonReturnEnum.FAILED.getCode(), msg);
    }

    /**
     * 失败返回，指定msg,data
     *
     * @param msg
     * @param data
     * @return : Result<T>
     */
    public static <T> Result<T> failed(String msg, T data) {
        return restResult(data, CommonReturnEnum.FAILED.getCode(), msg);
    }

    /**
     * 失败返回，指定code,msg
     *
     * @param code
     * @param msg
     * @return : Result<T>
     */
    public static <T> Result<T> failed(int code, String msg) {
        return restResult(null, code, msg);
    }

    /**
     * 失败返回，指定code,msg,data
     *
     * @param code
     * @param msg
     * @param data
     * @return : Result<T>
     */
    public static <T> Result<T> failed(int code, String msg, T data) {
        return restResult(data, code, msg);
    }

    private static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}