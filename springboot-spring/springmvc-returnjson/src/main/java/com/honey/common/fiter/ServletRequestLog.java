package com.honey.common.fiter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet filter 打印日志
 *
 * @author lovely
 * @version 1.0
 * on 2021/4/13
 */
public class ServletRequestLog extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // "/api/servlet/test1"
        // "/"
        System.out.println("request.getRequestURI() = " + request.getRequestURI());

        // "/api/servlet/test1"
        // "/"
        System.out.println("request.getServletPath() = " + request.getServletPath());

        System.out.println("request.getMethod() = " + request.getMethod());


        // 向下执行
        filterChain.doFilter(request, response);
    }
}
