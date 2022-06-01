package com.revature;

import java.util.List;

import com.revature.models.Director;
import com.revature.models.Movie;
import com.revature.repositories.MovieDAO;

public class Launcher {
	public static void main(String[] args) {
		//Lets make a Try with resources to check if our database is connected
		//You should comment it out once you know you are connected, because it will try and close your Session
		//Which will cause all of your methods to fail
//		try(Session ses = HibernateUtil.getSession()){
//			System.out.println("Connection Successful");
//		}
//		catch (HibernateException e) {
//			System.out.println("Connection Failed");
//			e.printStackTrace();
//		}
		MovieDAO md = new MovieDAO();
		
		Director d1 = new Director("John", "Carpenter", 1948);
		Director d2 = new Director("Steven", "Spealburg", 1946);
		Director d3 = new Director("Tim", "Burton", 1958);
		Director d4 = new Director("Michael", "Bay", 1965);
		
		Movie m1 = new Movie("Halloween", "Horror", 9, d1);
		Movie m2 = new Movie("Jaws", "Thriller", 10, d2);
		Movie m3 = new Movie("Titanic", "Romance", 8, d2);
		Movie m4 = new Movie("Nightmare before Christmas", "Animated", 10, d3);
		Movie m5 = new Movie("Transformers", "Action", 3, d4);
		Movie m6 = new Movie("Peral Harbor", "Drama", 1, d4);

		md.insertMovie(m1);
		md.insertMovie(m2);
		md.insertMovie(m3);
		md.insertMovie(m4);
		md.insertMovie(m5);
		md.insertMovie(m6);
		
		
		
		//Lets get a list of all of our movies and see what the console says
		List<Movie> allMovies = md.getAllMovies();
		System.out.println("(Get all movies)==================================================");
		for(Movie m : allMovies) {
			System.out.println(m);
		}
		
		System.out.println("(Select by id)=====================================================");
		System.out.println(md.getMovieById(1));
		System.out.println("(Select by Director id)============================================");
		System.out.println(md.getMoviesByDirectorId(4));
		System.out.println("(Upodate Title)====================================================");
		m6.setTitle("Batman, but in Hawaii");
		md.updateMovieWithSessionMethod(m6);
		System.out.println(md.getMovieById(6));
	}
}
