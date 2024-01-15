package com.goodhabits.authbackend.security;


import com.goodhabits.authbackend.security.filter.AuthenticationFilter;
import com.goodhabits.authbackend.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");

        http.csrf().disable()
                .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/users/**").permitAll()
                        .requestMatchers("/users/register").permitAll()

                .anyRequest().authenticated())
                .addFilter(authenticationFilter);
        return http.build();
    }
}
