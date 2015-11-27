package com.test.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication().withUser("user").password("1").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("1").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("1").roles("ADMIN","DBA"); // dba has two roles
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
			//.antMatchers("/").permitAll()
			.antMatchers("/").access("hasRole('USER')")
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
			.antMatchers("/dba/**").access("hasRole('ADMIN') and hasRole('DBA')")
			.and().formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password")
			.and().csrf().and().exceptionHandling().accessDeniedPage("/403");
//			.and().exceptionHandling().accessDeniedPage("/AccessDenied");
			
	}
	
	
}
