package com.honey.common.exception;

import com.honey.common.ResultStatusEnum;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lovely
 * @version 1.0
 * on 2020/9/11
 */
@Getter
@Configuration
public class ResultException extends Exception {

    ResultStatusEnum statusEnum;


    public ResultException() {
        this(ResultStatusEnum.INTERNAL_SERVER_ERROR);
    }


    public ResultException(ResultStatusEnum statusEnum) {
        super(statusEnum.getMessage());
        this.statusEnum = statusEnum;
    }

    public ResultException(String message) {
        this(message, ResultStatusEnum.INTERNAL_SERVER_ERROR);
    }

    public ResultException(String message, ResultStatusEnum statusEnum) {
        super(message);
        this.statusEnum = statusEnum;
    }
}
