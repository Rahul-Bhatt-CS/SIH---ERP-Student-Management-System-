package com.Student_Management_System.SIH_ERP_System.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class StudentConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public SecurityFilterChain httpMapping(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(r ->
                r
                        .requestMatchers(HttpMethod.POST,"/register").permitAll()
                        .requestMatchers(HttpMethod.GET,"/test").hasAuthority("STUDENT")
                        .anyRequest()
                        .authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .csrf(c -> c.disable());

        return http.build();
    }
}
