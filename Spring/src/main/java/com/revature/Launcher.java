package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;

public class Launcher {
	public static void main(String[] args) {
		//We are simply, going to create an ApplicationContext object, and this will be near identical to anything you guys do on your own
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//This instantiates a new ApplicationContext object, which holds our spring beans!
		//We give it the applicationContext.xml file so it knows how to configure everything!
		
		//If we weren't using auto-wiring and were just using a Config class, we would need to make it like this
		//ApplicationContext ac = new AAnnotationConfigApplicationContext(Config.class);
		
		//Now that we have our spring container, we can make some beans!
		
		//We need to create a user object, and we will need to cast it because AppllicationContext cannot guess what kind of object it needs
		User u = (User) ac.getBean("user");
		
		//Lets look at what our bean looks like
		System.out.println(u);
		//We get a user object, but all the values are null so we dont get any userful information
		u.setId(1);
		u.setName("Patrick");
		u.getAccount().setBalance(1000.50); //To be able to access the account object in our user object, we need to use a getter and setter
		u.getAccount().setType("Checking");
		
		//Now user is full of data, lets look at it again
		System.out.println(u);
		
		//Lets make another bean
		User u2 = (User) ac.getBean("user"); //Will this work? Sometimes, it depends on your scope.
		//If you DO NOT set your scope in your bean, you will only be able to have 1 instance of the bean in your application
		//Which will cause this to have the same information as our first bean
		System.out.println(u2);
		
		u2.setId(2);
		u2.setName("Aly");
		System.out.println(u);
		System.out.println(u2);
		
		//Buttttt, when we make User prototype scoped, it will allow us to have multiple instances of our User beans!
		
	}
}
