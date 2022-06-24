package com.example.week4assigmentproducer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}secretpassword")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/api/**", "/api/**")
                .authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
