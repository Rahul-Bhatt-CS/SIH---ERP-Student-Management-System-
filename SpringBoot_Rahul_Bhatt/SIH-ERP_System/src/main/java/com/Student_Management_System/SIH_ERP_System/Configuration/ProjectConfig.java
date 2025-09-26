package com.Student_Management_System.SIH_ERP_System.Configuration;

import com.Student_Management_System.SIH_ERP_System.Security.Services.SecurityUser_StudentDetailsService;
import com.Student_Management_System.SIH_ERP_System.Security.Services.SecurityUser_AdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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
                .securityMatcher("/api/student/**", "/")
                .authorizeHttpRequests(r ->
                        r
                                .requestMatchers("/api/register").permitAll()
                                .requestMatchers("/api/student/**").hasAnyAuthority("STUDENT","ADMIN")
                                .anyRequest()
                                .authenticated()
                )
                .userDetailsService(securityUserStudentDetailsService)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }


    @Bean
    @Order(2)
    public SecurityFilterChain httpMapping(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/api/**")
                .authorizeHttpRequests(r ->
                r
                        .requestMatchers(HttpMethod.PUT,"/api/admin/**").hasAuthority("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .userDetailsService(securityUserAdminDetailsService)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
    //Faculty Security Rules to be Implimented.

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*")); // allow all origins
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
