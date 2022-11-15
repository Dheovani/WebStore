package springboot.springapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfigurer {

    @Autowired
    private JWTRequestFilter filter;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
            authz -> authz.requestMatchers("/api/v1/auth/signin", "/swagger-ui.html", "/v2/api-docs/**", "/swagger-resources/**").permitAll()
                            .requestMatchers("/api/**").authenticated()
        ).httpBasic();

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
    
}
