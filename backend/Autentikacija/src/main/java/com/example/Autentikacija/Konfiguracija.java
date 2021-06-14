package com.example.Autentikacija;

import com.example.Autentikacija.Security.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class Konfiguracija extends WebSecurityConfigurerAdapter {


    @Autowired
    private RequestFilter requestFilter;
    @Autowired
    private AuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Disable Cross Site Request Forgery security
                .csrf().disable()
                // Entry point for Unauthorized requests
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                // Enable anyone to access methods of Quoted mapping (without Authorisation)
                .and().authorizeRequests()
                .antMatchers("/profilRegistrovanog/**").permitAll()
                // Every other request needs Authorisation
                .anyRequest().authenticated()
                // Enable CORS layer (WebMvcConfig class)
                .and().cors()
                // Disables sessions for spring security (We use jwt to manage session)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // Makes RequestFilter class to execute before each controller method
                .and().addFilterBefore(requestFilter, BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST, "/profilRegistrovanog/**");
    }
}
