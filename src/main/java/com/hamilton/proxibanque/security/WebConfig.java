package com.hamilton.proxibanque.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

   @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       http.authorizeRequests().antMatchers(HttpMethod.GET,"/clients").permitAll() ;
       http.authorizeRequests().antMatchers(HttpMethod.GET,"/compteClient/**").permitAll() ;
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/Employe/conseillers").permitAll() ;
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/saveRetrait").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/Employe/createConseiller/**").permitAll() ;
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/saveRetrait").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/saveVersement").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/saveVirement").permitAll();

        //  http.authorizeRequests().antMatchers(HttpMethod.POST,"/aa/**").permitAll();
      //  http.authorizeRequests().antMatchers(HttpMethod.POST,"/aa/**").permitAll();

        //  http.authorizeRequests().antMatchers("/aa/**").hasAuthority("ADMIN");
        //http.authorizeRequests().antMatchers("/aa/**").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new JWTAutorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }



    }
