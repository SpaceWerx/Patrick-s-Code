package com.revature.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.model.Calculator;

public class CalculatorTests {
	//We need to make a calculator object so that we can test its tests
	public static Calculator c;
	
	
	//We will need some numbers to test with
	public int i = 5;
	public int j = 42;
	public int k = 0;
	public int result;
	
	//This runs before all other test methods
	@BeforeAll
	public static void createCalc() {
		c = new Calculator();
		System.out.println("This is inside of the @BeforeAll method");
	}
	
	//This will run after all other test methods
	@AfterAll
	public static void clearCalc() {
		c = null;
		System.out.println("This is inside the @AfterAll method");
	}
	
	//Lets make the actual tests now
	
	@Test
	public void testAdd() {
		System.out.println("This is inside the Test Add method");
		result = c.add(j, i); //This is the result of .add() method from our Calculator class
		assertTrue(result == 47);// This specifcally looks for where or not something resolves as true
	}
	
	@Test
	public void testAdd1() {
		System.out.println("This is inside the Test Add1 method");
		result = c.add(j, i); //This is the result of .add() method from our Calculator class
		assertTrue(result == 47);
		assertEquals(result,47); //assertEquals confuses me, but w/e
	}
	
	@Test
	public void testSubtract() {
		System.out.println("This is in the subtract test");
		result = c.subtract(i, j);
		assertEquals(-37,result);//This specifically looks if two things are equal
	}
	
	@Test
	public void testDivideByZeroThrowsException() {
		System.out.println("This is in the divide test method");
		assertThrows(ArithmeticException.class, () -> c.divide(i,k)); //This looks for an exception to be thrown
	}
	
}
