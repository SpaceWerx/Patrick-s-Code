package com.revature;

public class Launcher {
	
	public static void main(String[] args) {
		//We want to make a counts up to 10 and then back to 0
		int counter = -1;
		for(int i = 0; i <= 20; i++) {
			if(i <= 10) {
				counter++;
				System.out.println(counter);
				
			}
			else {
				counter--;
				System.out.println(counter);
			}
		
		}
		
	}
}
