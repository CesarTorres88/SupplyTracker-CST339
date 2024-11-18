package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.gcu.service.RegistrationServiceImpl;;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	RegistrationServiceImpl service;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/css/**", "/js/**", "/images/**").permitAll() // Allow access to registration and static resources
                .anyRequest().authenticated() // Require authentication for all other requests
            )
            .formLogin(login -> login
                .loginPage("/login") // Custom login page URL
                .permitAll() // Allow everyone to access the login page
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
                .logoutSuccessUrl("/login") // Redirect to home page after logout
                .permitAll()
            );

        return http.build();
    }

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}