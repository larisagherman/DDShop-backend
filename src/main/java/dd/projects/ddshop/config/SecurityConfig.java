package dd.projects.ddshop.config;

import dd.projects.ddshop.util.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf(csrf -> csrf.disable())       // Disable CSRF if your frontend is separate
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/swagger-ui/**",
//                                "/v3/api-docs/**",
//                                "/swagger-resources/**",
//                                "/webjars/**",
//                                "/api/**",
//                                "/products/**").permitAll()  // Allow unauthenticated access to login
//                        .anyRequest().authenticated()                // Protect all other endpoints
//                )
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // ⚠️ TEMPORARY: Allow every request without auth
                );
        return http.build();
    }

}

