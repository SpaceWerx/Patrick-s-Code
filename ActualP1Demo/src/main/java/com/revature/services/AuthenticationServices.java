package com.revature.services;

public class AuthenticationServices {

	public int login(String username, String password) {
		if(username.equals("manager") && password.equals("password")) {
			return 1;
		}
		else if(username.equals("employee") && password.equals("password")) {
			return 2;
		}
		else {
			return 0;
		}
	}
	//What would normally happen here, if you would call your DAO, your DAO would query the database, and you would compare values here. After which
	// You would send off if it worked or not
	//My recommendation to all of you, is have your login differentiate here
	//Because you need a manager AND employee menu, When a manager logs in, send a 201 status code, and have your JS put them on the Manager Menu
	//When a normal employee logs in, send a 202 status code, and have them sent to the Employee Menu
	
	//As well, I recommend that you ONLY pass the employee to the DAO, there is no need to also send the password
}
