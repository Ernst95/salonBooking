package com.salonbooking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Ernst on 2017/09/05.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder amb) throws Exception {
        amb.inMemoryAuthentication().withUser("user").password("user")
                .roles("USER").and().withUser("admin").password("admin").roles("ADMIN");
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and().authorizeRequests().antMatchers("/salonBooking/deleteCustomer/**")
                .hasRole("ADMIN").and().csrf().disable().headers().frameOptions().disable();
        /*httpSecurity.httpBasic().and().authorizeRequests().antMatchers("/salonBooking/deleteCustomer")
                .hasRole("ADMIN").and().csrf().disable().headers().frameOptions().disable();*/
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/salonBooking/deleteCustomer").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("ADMIN");
    }*/
}
