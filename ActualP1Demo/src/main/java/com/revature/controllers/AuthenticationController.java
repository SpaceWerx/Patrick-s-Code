package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthenticationServices;

import io.javalin.http.Handler;

public class AuthenticationController {

	AuthenticationServices as = new AuthenticationServices();
	
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		
		Gson gson = new Gson();
		//I recommend you make this an employee object 
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);

		if(as.login(LDTO.getUsername(), LDTO.getPassword()) == 1) {
			ctx.status(201);
			ctx.result("Login Sucessful!");
		}
		else if(as.login(LDTO.getUsername(), LDTO.getPassword()) == 2) {
			ctx.status(202);
			ctx.result("Login Sucessful!");
		}
		else {
		ctx.result("Login Failed!");
		ctx.status(401);
		}
	};
	
}
