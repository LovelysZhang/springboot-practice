package com.core.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 *
 * @author lovely
 * on 2019/2/6
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("my filter process ***********");
        // 将请求放行出去
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
