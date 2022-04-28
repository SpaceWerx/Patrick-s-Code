package com.revature.models;

public class TerinCar extends Cars {
	public int year = 2015;
	public String color = "Gray";
	public int mileage = 78000;
	public double potato = 6900.53;
	
	//This is overriding
	public void drive() {
		System.out.println("We dun diddly crashed it");
	}
	
	public void add(int x, int y, int z) {
		System.out.println(x + y + z);
	}
}
