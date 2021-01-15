package com.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity配置类
 *
 * @author lovely
 * on 2020/2/12
 */
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 授权规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        // 开启登录功能
        // 如果没有登录，没有权限会来到登录页
        http.formLogin()
                // 设置表单提交的参数名
                .usernameParameter("user")
                .passwordParameter("pwd")
                // 将登录页换为自己的登录页,此处为get请求
                .loginPage("/userlogin");
                // 登录成功forward
//                .successForwardUrl("/userlogin");
        // 1、/login Spring生成的登录页
        // 2、重定向到 /login?error表示登录失败
        // 3、更多详细规则
        // 4、默认post形式的/login代表处理登录
        // 5、一旦定制loginPage，那么loginPage的post请求就是登录



        // 配置的自动注销功能
        // 注销后返回首页
        http.logout().logoutSuccessUrl("/");
        // 1、访问logout 表示用户注销清空session
        // 2、注销成功返回 login?logout 页面

        // 开启记住我功能.退出浏览器保存登录用户
        // 原理：根据cookie
        http.rememberMe().rememberMeParameter("remember");
        // 登录成功以后，将cookie发给浏览器保存，以后访问带上这个cookie
        // 点击注销会删除这个cookie
    }

    /**
     * 认证规则
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("san").password("123").roles("VIP1", "VIP2")
                .and()
                .withUser("si").password("234").roles("VIP2", "VIP3")
                .and()
                .withUser("wu").password("345").roles("VIP3")
                .and().passwordEncoder(new CustomPasswordEncoder());

    }

    /**
     * 密码加密
     * https://blog.csdn.net/Hello_World_QWP/article/details/81811462
     */
    private class CustomPasswordEncoder implements PasswordEncoder {
        @Override
        public String encode(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override
        public boolean matches(CharSequence charSequence, String s) {
            return charSequence.equals(s);
        }
    }

}
