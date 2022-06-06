package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.models.Account;
import com.revature.models.User;

@Configuration //This is a class that is specifically used for Bean configuration
public class Config {
	
	//This is an important step I also forgot if you are doing non-auto-wiring configuration
	//But I like to auto-wire, so I am just going to comment all of this stuff out
	//You should know the general syntax for this stuff and the annotations involved, but honestly, auto-wiring is better in my opinion!
	//We are going to be using Auto-wiring, no need to create this class
	
	
//	@Bean(name = "user")
//	public User getUser() {
//	//	return new User(); //This wont work on its own 
//		return new User(getAccount());
//	}
//	
//	@Bean(name = "account")
//	public Account getAccount() {
//		return new Account();
//	}
//	
	
}
