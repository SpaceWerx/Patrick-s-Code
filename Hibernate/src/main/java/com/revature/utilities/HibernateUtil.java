package com.revature.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//We are going to use this class in order to get our sessions connected to our data base. This will function similar to the ConnectionFactory in JDBC
// Our sessions will manage the actual connect to our postgre database
public class HibernateUtil {

	//We are going to use the SessionFacotry interface in order to get a Session
	
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	private static Session ses;
	
	
	
	public static Session getSession() {
		if(ses == null) { //if there isn't a session
			ses = sf.openSession();
		}
		return ses; //This will just return our session object
	}
	public static void closeSession() {
		ses.close();
		ses = null;
	}
	
	
	
	
}
