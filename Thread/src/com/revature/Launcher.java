package com.revature;

public class Launcher {
	public static void main(String[] args) {
	
		//Lets instantiate some objects for your lovedThread class
		LovedThread t0 = new LovedThread();
		LovedThread t1 = new LovedThread();

		
		//Lets also set the priority of some of the threads. This can be a value between 1-10
		//The higher the number, the greater priority that thread will have!
		//Priorities just ensure that certain threads run first (or last, depending on what you want) BUTTTT they do not 
		//guarantee that they will stay in that priority 
		t0.setPriority(1);//This SHOULD make t1 start last
		t1.setPriority(10);//This SHOULD make t2 start first
		
		System.out.println("(Before the Thread start() methods)==========================");
		t0.start();
		t1.start();
		
		LovedThread t2 = new LovedThread();
		
		t2.start();
		
		try {
			t2.join(500);//This .join() will throw this Thread to the bottom of the stack (main method)
			//Which should make t2 always finish last
			//Hmm... this isn't doing what I thought it would
			//This wasn't working as planned, so I added a "timeout" into the join method to make it actually work the way I want
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		//Y'all, threads are confusing and they befuddle my mind... 
	}
}
