package com.Student_Management_System.SIH_ERP_System.Configuration;

import com.Student_Management_System.SIH_ERP_System.Security.SecurityUser_StudentDetailsService;
import com.Student_Management_System.SIH_ERP_System.Security.SecurityUser_AdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class ProjectConfig {
    @Autowired
    SecurityUser_AdminDetailsService securityUserAdminDetailsService;
    @Autowired
    SecurityUser_StudentDetailsService securityUserStudentDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    @Order(1)
    public SecurityFilterChain httpmappingStudent(HttpSecurity http) throws Exception{
        http
                .securityMatcher("/register", "/test")
                .authorizeHttpRequests(r ->
                        r
                                .requestMatchers(HttpMethod.POST,"/register").permitAll()
                                .requestMatchers(HttpMethod.GET,"/").hasAuthority("STUDENT")
                                .anyRequest()
                                .authenticated()
                )
                .userDetailsService(securityUserStudentDetailsService)
                .formLogin(form -> form.disable())
                .httpBasic(Customizer.withDefaults())
                .csrf(c -> c.disable());
        return http.build();
    }


    @Bean
    @Order(2)
    public SecurityFilterChain httpMapping(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(r ->
                r
                        .requestMatchers(HttpMethod.GET,"/unregisteredStudents").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/approveStudent/*").hasAuthority("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .userDetailsService(securityUserAdminDetailsService)
                .formLogin(form -> form.disable())
                .httpBasic(Customizer.withDefaults())
                .csrf(c -> c.disable());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*")); // allow all origins
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
