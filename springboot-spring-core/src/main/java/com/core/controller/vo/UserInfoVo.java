package com.core.controller.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author lovely
 * @version 1.0
 * on 2021/1/13
 */
@Data
public class UserInfoVo {

    private Long userId;

    @NotEmpty
    @Length(min = 2, max = 10)
    private String userName;

    @NotNull
    // @Length(min = 6, max = 20)
    private String account;

    // @NotNull
    // @Length(min = 6, max = 20)
    private String password;
}
