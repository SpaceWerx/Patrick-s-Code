package com.revature;

import com.revature.models.Cars;
import com.revature.models.Shows;
import com.revature.models.TerinCar;

public class Launcher {
//	private String name;
//	private String genre;
//	private int length;
//	private boolean series;
//	private int rating;
//	private String langauge;
	public static void main(String[] args) {
		Shows s = new Shows();
		Cars c = new Cars();
		TerinCar tc = new TerinCar();
		
		
		s.setName("Black List");
		s.setGenre("Thriller?, Spy?, Investigative?, Comedy?");
		s.setLength(45);
		s.setSeries(true);
		s.setRating(4);
		s.setLangauge("English");
				
		System.out.println(s.getGenre());
		System.out.println(s.getName());
		
		System.out.println("================================================================");
		c.drive();
		System.out.println(c.color);
		System.out.println(c.mileage);
		c.add(c.mileage, c.year);
		
		System.out.println("================================================================");
		tc.drive();
		System.out.println(tc.color);
		System.out.println(tc.mileage);
		System.out.println(tc.type);
		tc.add(tc.mileage, c.year, (int)tc.potato);
		System.out.println("================================================================");

		System.out.println(tc.potato);
		System.out.println((short)tc.potato);
		// This will be most useful when we query the database via a variable, name for instance, 
		// and then we can see all the other values based on that name
	}
}
