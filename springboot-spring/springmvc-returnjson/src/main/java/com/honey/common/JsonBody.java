package com.honey.common;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * 全局返回值处理
 * 由@ResponseBody派生属性
 *
 * @author lovely
 * @version 1.0
 * on 2020/9/11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@ResponseBody
public @interface JsonBody {
}
