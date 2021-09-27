package com.hwgif.configure.security;

import com.google.gson.Gson;
import com.hwgif.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lc.huang
 * @description
 * @date 2019/11/26
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
     private HwgifUserDetailsService userService;

    @Autowired
    private HwgifAuthenticationProvider hwgifAuthenticationProvider;

    @Autowired
    private HwgifUserDetailsService hwgifUserDetailsService;

    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;



    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .csrf() //跨站
                .disable() //关闭跨站检测
                .authorizeRequests()//验证策略策略链
                // 如果有允许匿名的url，填在下面
                .antMatchers("/public/**").permitAll() //无需登录路径
                .antMatchers("/v2/api-docs",//swagger api json
                        "/swagger-resources/configuration/ui",//用来获取支持的动作
                        "/swagger-resources",//用来获取api-docs的URI
                        "/swagger-resources/configuration/security",//安全选项
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/signin").permitAll()
                .anyRequest().authenticated()
                .and()
                // 设置登陆页
                .formLogin().loginPage("/signin")
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                // post提交登录地址  无需实现
                .loginProcessingUrl("/login")
                // 自定义登陆用户名和密码参数，默认为username和password
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(hwAccessDeniedHandler())
                .and()
                .logout().permitAll();

//        拦截器这里加

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //将自定义的CustomAuthenticationProvider装配到AuthenticationManagerBuilder
        auth.authenticationProvider(hwgifAuthenticationProvider);
        //将自定的CustomUserDetailsService装配到AuthenticationManagerBuilder
//        auth.userDetailsService(hwgifUserDetailsService).passwordEncoder(new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return s.equals(charSequence.toString());
//            }
//        });
    }


    /**
     * security检验忽略的请求，比如静态资源不需要登录的可在本处配置
     * @param web
     */
    @Override
    public void configure(WebSecurity web){

//        一般只有ignoring()配置需要重写：
//
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }
    //密码加密配置
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
    //登入成功
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            /**
             * 处理登入成功的请求
             *
             * @param httpServletRequest
             * @param httpServletResponse
             * @param authentication
             * @throws IOException
             * @throws ServletException
             */
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write(new Gson().toJson(CommonResult.successResult("登录成功")));
                out.flush();
                out.close();
            }
        };
    }
    //登录失败
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler(){
        return new AuthenticationFailureHandler() {
            /**
             * 处理登录失败的请求
             * @param httpServletRequest
             * @param httpServletResponse
             * @param e
             * @throws IOException
             * @throws ServletException
             */
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write(new Gson().toJson(CommonResult.failResult(0,"登录失败",null)));
                out.flush();
                out.close();
            }
        };
    }
    //登出处理
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new LogoutSuccessHandler() {
            /**
             * 处理登出成功的请求
             *
             * @param httpServletRequest
             * @param httpServletResponse
             * @param authentication
             * @throws IOException
             * @throws ServletException
             */
            @Override
            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write(new Gson().toJson(CommonResult.successResult("登出成功")));
                out.flush();
                out.close();
            }
        };
    }

    @Bean
    public AccessDeniedHandler hwAccessDeniedHandler() {
        AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write(new Gson().toJson(CommonResult.failResult(-1,"权限不足",null)));
                out.flush();
                out.close();
            }
        };
        return accessDeniedHandler;
    }



}
