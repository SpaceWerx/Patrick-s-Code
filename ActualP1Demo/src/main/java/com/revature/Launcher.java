package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utilities.ConnectionFactory;

public class Launcher {
	public static void main(String[] args) throws SQLException {
	
		
		//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}	

	
		//Make the menu	run, its only 2 lines of code	
		Menu menu = new Menu();
			
		menu.displayMenu();
	
	}
}
