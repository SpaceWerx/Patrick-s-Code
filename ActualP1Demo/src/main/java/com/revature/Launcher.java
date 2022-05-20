package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthenticationController;
import com.revature.controllers.EmployeeController;
import com.revature.utilities.ConnectionFactory;

import io.javalin.Javalin;

public class Launcher {
	public static void main(String[] args) throws SQLException {
		EmployeeController ec = new EmployeeController();
		AuthenticationController ac = new AuthenticationController();
		//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}	

	
		//Make the menu	run, its only 2 lines of code	
//		Menu menu = new Menu();
//			
//		menu.displayMenu();
		
		//This is our Javalin object (Which creates the connection, done)
		Javalin app = Javalin.create(
			config -> {
				config.enableCorsForAllOrigins(); //This is what allows teh server to process JS requests from anywhere
			}
		).start(3000);
	
		//Now we need our endpoints
		app.get("/employee", ec.getEmployeesHandler);
		
		app.post("/employee", ec.insertEmployeesHandler);
		
		//In the future, we will also add a log in function
		app.post("/login", ac.loginHandler);
		
	}
}
