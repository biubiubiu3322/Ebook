package com.su.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义认证对象
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    //user Details Service验证
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new MyPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { //配置策略
        //请求权限配置
        http.authorizeRequests()
                //任何请求，登录后方可访问。
                .anyRequest().authenticated()
                .and()
                //登陆界面参数
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index",true)
                // 强制指定登陆成功后跳转的路劲  successFordwardUrl 强制定向
                /*.successHandler(new ForwardAuthenticationSuccessHandler("/success?status=true"))*/
                .permitAll()
                //设置注销成功后跳转页面，默认是跳转到登录页面
                .and().logout().logoutSuccessUrl("/login").permitAll()
                //权限访问失败界面，关键，如果不定义的话会抛出异常
                .and().exceptionHandling().accessDeniedPage("/login?error")
               ;
                //csrf认证关闭
                http.csrf().disable();
                //允许加载ifame模块框架
                http.headers().frameOptions().disable();

              /*  *//*废弃的方法*//*
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/success")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .headers().frameOptions().disable()
                .and()
                .logout().permitAll(); //注销行为任意访问*/
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers(
                "/css/**", "/js/**",
                "/img/**", "/plugins/**",
                "**/favicon.ico","/assets/**","/register","/ebook/regiest");
    }
}
