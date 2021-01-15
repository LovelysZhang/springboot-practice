package com.core.component;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @param <T>
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -504027247149928390L;

    private int code;
    private String msg;
    private String exceptionMsg;
    private T body;

    public static <T> Result ok(T body) {
        return new Result<>()
                .setBody(body)
                .setCode(0)
                .setMsg("");
    }

    public static Result ok() {
        return new Result<>()
                .setCode(0)
                .setMsg("");
    }

    public static Result fail(String msg) {
        return new Result<>()
                .setCode(0)
                .setMsg(msg);
    }

    public static Result fail(String msg, String exceptionMsg) {
        return new Result<>()
                .setCode(0)
                .setMsg(msg)
                .setExceptionMsg(exceptionMsg);
    }
}
