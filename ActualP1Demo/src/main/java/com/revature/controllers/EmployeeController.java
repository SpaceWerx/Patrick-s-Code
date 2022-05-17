package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import io.javalin.http.Handler;

public class EmployeeController {
	EmployeeService es = new EmployeeService();
	
	
	public Handler getEmployeesHandler = (ctx) ->{
//This does not work anymore like it was intended to, do not use this		
//		if(ctx.req.getSession(false) != null) {
//			
//		}
//		else {
//			ctx.status(401);
//		}
		List<Employee> allEmployees = es.getEmployees();
		
		Gson gson = new Gson();
		
		String JSONObject = gson.toJson(allEmployees);
		
		ctx.result(JSONObject);
		ctx.status(200);
	};
	
	
	public Handler insertEmployeesHandler = (ctx) ->{
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Employee employee = gson.fromJson(body, Employee.class);
		
		es.addEmployee(employee);
		
		ctx.result("Employee successfully added!");
		ctx.status(201);
		
	};

}
