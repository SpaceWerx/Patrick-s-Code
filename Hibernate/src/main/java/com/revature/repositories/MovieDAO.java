package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import org.hibernate.Transaction;

import org.hibernate.Session;

import com.revature.models.Movie;
import com.revature.utilities.HibernateUtil;

public class MovieDAO {

	public void insertMovie(Movie movie) {
		Session ses = HibernateUtil.getSession(); //This will open our session object to establish a connection to our database
		ses.save(movie);
		HibernateUtil.closeSession(); //This closes the session which will help prevent a memory leak issue
	} //This is all that is required to insert something into your database
	
	//We are going to use HQL for this one
	public List<Movie> getAllMovies(){
		Session ses = HibernateUtil.getSession(); //This opens the session
		List<Movie> movieList = ses.createQuery("FROM Movie").list(); //This is HQL which will get all items from the Movie Table
		HibernateUtil.closeSession(); //This closes the session
		return movieList; //This returns the list
	}
	
	public Movie getMovieById(int id) {
		Session ses = HibernateUtil.getSession(); //opens the session
		Movie movie = ses.get(Movie.class, id); //This will select all movies by ID (This should result in only one movie, but id is a PK which is unique)
		HibernateUtil.closeSession(); //closes the session
		return movie; //returns the movie
	}
	
	//lets do a get all with HQL
	public List<Movie> getMoviesByDirectorId(int id){
		Session ses = HibernateUtil.getSession(); //opens the session
		Query q = ses.createQuery("FROM Movie m WHERE m.director.id = ?0"); //This is similar to our prepared statment in JDBC
		//The 0 is what we are targeting to change with our setParameter
		q.setParameter(0, id); //This sets the ? to the id that we went to this method
		List<Movie> movieList = q.getResultList(); //This will create a List that will hold the results of our query
		HibernateUtil.closeSession(); //closes the session
		return movieList; //returns our list
	}
	//We will use session method to update
	public void updateMovieWithSessionMethod(Movie movie) {
		Session ses = HibernateUtil.getSession(); //opens the session
		Transaction tran = ses.beginTransaction(); //ALL and I do mean ALL update and delete methods MUST happen within a transaction
		ses.merge(movie); //this will actually merge our movie object with the database 
		tran.commit(); //This will commit the transaction if it did not encounter a problem
		HibernateUtil.closeSession(); //closes the session

	}
	//We will use HQL to update
	public void updateMovieWithHQL(Movie movie) {
		Session ses = HibernateUtil.getSession(); //opens the session
		Transaction tran = ses.beginTransaction(); //ALL and I do mean ALL update and delete methods MUST happen within a transaction
		Query q = ses.createQuery("UPDATE Moive SET title = '" + movie.getTitle() + "' WHERE id = " + movie.getMovie_id());
		//This is what that string looks like when data is given "UPDATE Movie SET title = 'New Movie Title' Where id = 2"
		q.executeUpdate();
		tran.commit(); //This will commit the transaction if it did not encounter a problem
		HibernateUtil.closeSession(); //closes the session
	}
	
}
