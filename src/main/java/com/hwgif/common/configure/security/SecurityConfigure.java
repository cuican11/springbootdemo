package com.hwgif.common.configure.security;

import com.hwgif.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lc.huang
 * @description
 * @date 2019/11/26
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
    @Autowired
     private HwgifUserDetailsService userService;


     @Override
     protected void configure(HttpSecurity http) throws Exception {
         //  允许所有用户访问"/"和"/index.html"
         http.authorizeRequests()
                 .antMatchers("/", "/index.html").permitAll()
                 .anyRequest().authenticated()   // 其他地址的访问均需验证权限
                 .and()
                 .formLogin()
                 .loginPage("/login.html")   //  登录页
                 .failureUrl("/login-error.html").permitAll()
                 .and()
                 .logout()
                 .logoutSuccessUrl("/index.html");
     }

     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
     }

      @Bean
     public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
     }
}
