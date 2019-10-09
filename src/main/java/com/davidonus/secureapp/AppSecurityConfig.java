package com.davidonus.secureapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends 	WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailService;
	
	
	  @Bean 
	  public AuthenticationProvider authProvider(){ DaoAuthenticationProvider
	  provider = new DaoAuthenticationProvider();
	  provider.setUserDetailsService(userDetailService);
	  provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); return
	  provider; }
	 
	
/*	  @Override public UserDetailsService userDetailsService() {
	  
	  //A user is an array of UserDetail parameters: A Name, Password, and a Role
	  List<UserDetails> users = new ArrayList<>();
	  
	  //add in the user configurations (builder pattern) with the UserDetailService
	  //the User class will help with this. Open its declaration for more.
	  users.add(User.withDefaultPasswordEncoder().username("David").password("a").
	  roles("USER").build());
	  
	  return new InMemoryUserDetailsManager(users);
	  
	  //TODO @Test: What if any of these attributes are empty?
	   * }
*/	  
	 
}