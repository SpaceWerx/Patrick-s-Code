package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //This is a stereotype annotation that gives up Spring MVC functionality
//It lets us handle HTTP requests!
public class SpringController {

	@GetMapping("/hello") //This will monitor, ANY GET Http request that the Spring application recieves and it will send a response
	public ResponseEntity<String> hello(){
		//return ReponseEntity.status(200).body(response = ss.hello()); //This is what it will look like in the future
		return ResponseEntity.status(200).body("This is the first time you are seeing Spring MVC work");
	}
	
	
}
