/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Admin
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = "com.restaurant")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
            .usernameParameter("username")
            .passwordParameter("password");
        
        http.formLogin().defaultSuccessUrl("/")
                        .failureUrl("/login?error");
        
        http.logout().logoutSuccessUrl("/login");
        
        http.exceptionHandling()
            .accessDeniedPage("/login?accessDenied");
        
        http.authorizeRequests().antMatchers("/").permitAll()
            .antMatchers("/employee").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/addemp").access("hasRole('ROLE_ADMIN')")
//            .antMatchers("/**/add").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/services").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/statsRe").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/statsDen").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/viewBook").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/customerInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
            .antMatchers("/bookParty").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
            .antMatchers("/addFeedback/**/").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
            
        http.csrf().disable();

    }
    
    
   
}
