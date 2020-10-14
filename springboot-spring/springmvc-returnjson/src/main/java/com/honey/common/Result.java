package com.honey.common;

import com.google.common.base.Strings;
import lombok.Getter;
import lombok.ToString;

/**
 * 返回体类
 *
 * @author lovely
 * @version 1.0
 * on 2020/9/11
 */
@Getter
@ToString
public class Result<T> {
    /**
     * 业务错误码
     */
    private Integer code;
    /**
     * 信息描述
     */
    private String message;
    /**
     * 返回参数
     */
    private T data;

    private Result(ResultStatusEnum resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.data = data;
    }

    private Result(ResultStatusEnum resultStatus, String message, T data) {
        this.code = resultStatus.getCode();
        this.message = message;
        this.data = data;
    }

    /**
     * 业务成功返回业务代码和描述信息
     */
    public static Result<Void> success() {
        return new Result<Void>(ResultStatusEnum.SUCCESS, null);
    }

    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultStatusEnum.SUCCESS, data);
    }

    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> Result<T> success(ResultStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return success(data);
        }
        return new Result<T>(resultStatus, data);
    }

    /**
     * 业务异常返回业务代码和描述信息
     */
    public static <T> Result<T> failure() {
        return new Result<>(ResultStatusEnum.INTERNAL_SERVER_ERROR, null);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static <T> Result<T> failure(ResultStatusEnum resultStatus) {
        return failure(resultStatus, null);
    }

    /**
     * @param message 自定义异常信息
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(String message) {
        if (Strings.isNullOrEmpty(message)) {
           return failure();
        }
        return new Result<T>(ResultStatusEnum.INTERNAL_SERVER_ERROR, message, null);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static <T> Result<T> failure(ResultStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return new Result<T>(ResultStatusEnum.INTERNAL_SERVER_ERROR, null);
        }
        return new Result<T>(resultStatus, data);
    }
}
