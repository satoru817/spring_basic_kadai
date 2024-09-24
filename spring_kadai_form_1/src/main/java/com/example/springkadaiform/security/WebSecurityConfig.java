package com.example.springkadaiform.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests().requestMatchers("/login", "/resources/**").permitAll()
                .anyRequest().authenticated()
        .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login").defaultSuccessUrl("/form?loggedIn")
                .failureUrl("/form?error").permitAll()
                .and()
                .logout().logoutSuccessUrl("/loggedOut").permitAll();

        return http.build();//returns a object of SecurityFilterChain
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
