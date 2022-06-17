package com.infy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SpringConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("umesh").password(passwordEncoder().
				encode("jalgaon123")).roles("admin").and().withUser("amit").
		        password(passwordEncoder().encode("Nasik123")).roles("user");
	}
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests().antMatchers("/rest/customer/**").hasRole("admin").anyRequest().
		authenticated().and().httpBasic();
		http.csrf().disable();
		
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
