package com.sim.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        //注入userDetailsService，需要实现userDetailsService接口
//        auth.authenticationProvider(authenticationProvider());
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.exceptionHandling()
//                .and()
//                .authorizeRequests()//配置安全策略
//                .antMatchers("/assets/**").permitAll()//定义/请求不需要验证
//                .anyRequest().authenticated()//其余的所有请求都需要验证
//                .and()
//                .logout()
//                .logoutUrl("/loginout")
//                .deleteCookies("userdetail", "JSESSIONID")
//                .permitAll()//定义logout不需要验证
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/user/login")
//                .permitAll()
//                .and()
//                .csrf().disable();//使用form表单登录
        //测试没有权限
        http.authorizeRequests()//配置安全策略
                .anyRequest().permitAll().and().csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
