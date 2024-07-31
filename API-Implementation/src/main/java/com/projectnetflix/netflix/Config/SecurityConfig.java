package com.projectnetflix.netflix.Config;

import com.projectnetflix.netflix.Model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static  org.springframework.security.config.Customizer.withDefaults;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth-> auth.requestMatchers("/register","/error").permitAll().anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        Collection<UserDetails> users= new ArrayList<>();
        UserDetails userDetails=  User.withDeaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        users.add(userDetails);
        UserDetails userDetails1 = User.withDeaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("USER")
                .build();
        users.add(userDetails1);
        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
