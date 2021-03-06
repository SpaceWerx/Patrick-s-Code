package com.revature;

public class Launcher {
	
	public static void main(String[] args) {
		//Nesting is full putting "stuff" inside of other stuff of the same kind
		boolean potato = true;
		// A singluar = sign, is how you set the value of a variable, if you want to compare two things, you double ==
		int bananas = 5;
		System.out.println("(if-statement)=====================================================================");

		// If statements, run the FIRST ONE ONLY
		if (potato == true) {
			System.out.println("Thats great!");
		}
		// This ONLY runs when an if statement fails
		else if (bananas == 5) {
			System.out.println("This is also great!");
		}
		//else happens when everything ELSE fails
		else {
			System.out.println("Well that sucks!");
		}
		System.out.println("(for-loop)=====================================================================");

		int[] dog = new int[60];
		
		for (int i = 0; i < dog.length; i++) {
			System.out.println(i);
		}
		
		//We are going to skip Enhanced for loops, because I dont want to get down the rabbit hole of the collections API
		System.out.println("(try-catch)=====================================================================");
		try {
			System.out.println(10/0);
		}
		catch(ArithmeticException e){
			System.out.println("The issue was caught");
			e.printStackTrace(); //This is only really useful while you are building the code, to figure out what went wrong.
		}
		finally {
			System.out.println("The try-catch block fully ran");
		}
		
		System.out.println("(switch)=====================================================================");
		bananas = 51;
		switch(bananas) {
		
		case 1: System.out.println("The number was 1");
			break;
		case 2: System.out.println("The number was 2");
			break;
		case 3: System.out.println("The number was 3");
			break;
		case 4: System.out.println("The number was 4");
			break;
		case 5: System.out.println("The number was 5");
			break;
		default:System.out.println("You dun goofed");
		}
		
		System.out.println("(while-loop)=====================================================================");
		int x = 1;
		while (potato == true) {
			System.out.println(x++);
			if (x == 50) {
				break;
			}
		}
		
		System.out.println("(do-while-loop)=====================================================================");
		int y = 10;
		do {
			System.out.println("I like favabeans");
			y++;
		}while(y < 15); 
		
		
		
	}
}
