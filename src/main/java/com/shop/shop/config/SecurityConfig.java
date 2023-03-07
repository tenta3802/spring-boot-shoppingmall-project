package com.shop.shop.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig {

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /* @formatter:off */
        http
                .authorizeHttpRequests()
                .antMatchers("/", "/main","/member/**","/item/**","/images/**").permitAll() //설정한 리소스의 접근을 인증절차 없이 허용
                .antMatchers("/admin/**").hasRole("ADMIN") //ADMIN 권한만 접근 가능
                .anyRequest().authenticated() // 그 외 모든 리소스를 의미하며 인증 필요
                .and()
                .formLogin()
                .loginPage("/member/login") // 기본 로그인 페이지
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/member/login/fail")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("member/logout"))
                .logoutSuccessUrl("/");
        return http.build();
        /* @formatter:on */
    }
}
