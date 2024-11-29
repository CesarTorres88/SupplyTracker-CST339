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
import com.gcu.service.RegistrationServiceImpl;

/**
 * SecurityConfig
 *
 * This class configures the security settings for the application, including
 * user authentication and authorization, password encoding, and custom login/logout behavior.
 *
 * Annotations:
 * - @Configuration: Indicates that this class is a Spring configuration class.
 * - @EnableWebSecurity: Enables Spring Security for the application.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * The service used for user authentication and registration.
     */
	@Autowired
	RegistrationServiceImpl service;

    /**
     * Configures the security filter chain, which defines the security rules for HTTP requests.
     *
     * @param http the {@link HttpSecurity} object used to configure security.
     * @return the configured {@link SecurityFilterChain}.
     * @throws Exception if there is an error configuring security.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/main", "/login", "/images/**").permitAll() // Allow access to registration and static resources
                .anyRequest().authenticated() // Require authentication for all other requests
            )
            .formLogin(login -> login
                .loginPage("/login").permitAll() // Allow everyone to access the login page
                .defaultSuccessUrl("/products", true)
            )
            .logout(logout -> logout
                .logoutUrl("/logout") //URL for logging out
				.invalidateHttpSession(true) //Invalidate the session
				.clearAuthentication(true) // Clear authentication details
                .logoutSuccessUrl("/login") // Redirect to login page after logout
                .permitAll()
            )
            .httpBasic(); // Enable basic authentication

        return http.build();
    }


    /**
     * Configures the authentication manager with a custom user details service and password encoder.
     *
     * @param auth the {@link AuthenticationManagerBuilder} to configure authentication.
     * @throws Exception if there is an error configuring authentication.
     */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}


    /**
     * Provides a password encoder bean for encoding and decoding passwords using BCrypt.
     *
     * @return a {@link BCryptPasswordEncoder} instance.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}