package com.myprojects.watcher.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.csrf(csrf -> csrf.disable()).
			authorizeHttpRequests(authorize -> authorize.
            requestMatchers("/movies/public/**").permitAll().
            anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults()); 
    	return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
    	UserDetails Akash = User.builder()
                .username("Akash")
                .password(passwordEncoder().encode("Akash@1223"))
                .roles("USER")
                .build();

        UserDetails Avinash = User.builder()
                .username("Avinash")
                .password(passwordEncoder().encode("Avi@1223"))
                .roles("ADMIN")
                .build();
        
        return new InMemoryUserDetailsManager(Avinash, Akash);
    }
}
