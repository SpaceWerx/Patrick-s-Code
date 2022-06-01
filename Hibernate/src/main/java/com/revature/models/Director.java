package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //This will make our class a table in our database
//We want the Javax.persistence import for all of these annotations
@Table(name = "director")// This changed teh name of our table to lower case director
//@Table allows us to change some values for our tables
public class Director {

	@Id //This will label "id" as a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This will make our Primary key serialized
	@Column(name = "director_id") //I could just call id (director_id), but I want to show the @Column annotation being used
	private int id;
	@Column(unique = true, nullable = false) //This tells Hiberate that the variable is a column in our table, but is unneeded
	private String f_name;
	@Column(nullable = false)   //I am showing that @Column is optional
	private String l_name;
	private String studio_name;

	//Boilerplate Code here......................
	//no args constructor
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}
	//all args constructor
	public Director(int id, String f_name, String l_name, String studio_name) {
		super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.studio_name = studio_name;
	}
	//left out the ID field so that we can insert values
	public Director(String f_name, String l_name, String studio_name) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.studio_name = studio_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getStudio_name() {
		return studio_name;
	}
	public void setStudio_name(String studio_name) {
		this.studio_name = studio_name;
	}
	@Override
	public String toString() {
		return "Director [id=" + id + ", f_name=" + f_name + ", l_name=" + l_name + ", studio_name=" + studio_name
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + ((studio_name == null) ? 0 : studio_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (id != other.id)
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		if (studio_name == null) {
			if (other.studio_name != null)
				return false;
		} else if (!studio_name.equals(other.studio_name))
			return false;
		return true;
	}
	
	
	
}
