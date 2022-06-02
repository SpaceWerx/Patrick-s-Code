package com.revature;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher {
	public static void main(String[] args) {
		
		//This is our boolean to keep our program running so we can use the CLI 
		boolean displayMenu =true;
		
		//This is our Scanner object to take user inputs
		Scanner scan = new Scanner(System.in);
		
		
		//This is our Logger object, that will allow us to Log things
		Logger log = LogManager.getLogger(Launcher.class);
		
		while(displayMenu){
			System.out.println("Hello fellow Human! Welcome to the Login Menu!");
			System.out.println("---------- Please log in ----------");
			//This is a logging tag that when executed will put this message in our logs file
			log.info("/User accessed login prompt/");
			
			//This is to take in our username and password
			System.out.println("Username: ");
			String username = scan.nextLine();
			System.out.println("Password: ");
			String password = scan.nextLine();
			
			//This will log us in
			if(username.equals("user") && password.equals("password")) {
				log.info("/User successfully logged in/");
				
				
				System.out.println("Is this the Krusty Krab");
				System.out.println("   Yes   |   No   ");
				String input1 = scan.nextLine();
				//lets log what they entered
				log.info("/User's answer was: " + input1 + "/");
				
				if(input1.equals("Yes")) {
					System.out.println("What would you like to order?");
					String order = scan.nextLine();
					//Lets log their order
					log.info("/User's order is: " + order + "/");
				}
				else if(input1.equals("No")) {
					System.out.println("No, this is Patrick!!");
					log.info("/This is infact Patrick/");
				}
				else {
					System.out.println("How did you mess up a yes or no question?");
					log.info("/I don't think the User is all that smart/");
				}
				
				
				System.out.println("What do you want to do today?");
				String input2 = scan.nextLine();
				log.info("/User wishes to do: " + input2 + " today/");
				
				if(input2.equals("World Domination")) {
					System.out.println("Well that is a lofty goal!");
					log.fatal("/I think the User has a few loose screws, if you know what I mean/");
				}
				else if(input2.equals("Sleep")) {
					System.out.println("Someone is lazy, huh?");
					log.info("/User is clearly a procrastinator/");
				}
				else if(input2.equals("Gaming")) {
					System.out.println("Get Gud Scrub");
					log.info("/User got Rektd/");
				}
				else {
					System.out.println("Well that's nice!");
					log.info("/User plans on doing: " + input2 + "/");
				}
				displayMenu = false;
			}
			else {
				//This will log a warning that a user failed to log in
				log.warn("/User failed to log in/");
				displayMenu = false;
			}
			
			
			
			
		}
		
		
	}
}
