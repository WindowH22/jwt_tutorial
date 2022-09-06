package com.example.jwt_tutorial.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // H2-console 하위 모든 요청들과 파비콘 관련요청은 Spring Security 로직을 수행하지 않도록 설정


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        "/h2-console/**"
                        ,"/favicon.ico"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // httpServletRequest를 사용하는 요청들에 대한 접근제한을 설정하겠다.
                .authorizeRequests()
                // 해당 ""에 대한 접근을 인증없이 허용하겠다.
                .antMatchers("/api/hello").permitAll()
                // 나머지접속은 인증을 걸겠다.
                .anyRequest().authenticated();
    }
}
