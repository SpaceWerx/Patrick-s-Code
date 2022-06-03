package com.revature;

//This Thread will extend the thread class and override the run() method
public class LovedThread extends Thread{

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			//This is our StringBuffer and we will populate it with the name of the current thread we are using
			//We are using StringBuffer because it IS THREAD SAFE!!!!!!!
			StringBuffer sb = new StringBuffer(Thread.currentThread().getName());
			//This will append a message onto our StingBuffer
			sb.append(" is doing its job!");
			
			System.out.println(sb);
			
			
			//This will just be to see that the thread is working, but I will probably comment it out
			try {
				Thread.sleep(500);//Threads will wait 500 milliseconds before running!
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread has finished!");
	}
	
	
	
}
