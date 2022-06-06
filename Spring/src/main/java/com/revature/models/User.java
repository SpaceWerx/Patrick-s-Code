package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //This will make our User class a bean
@Scope("prototype") //This will change our bean scope from the default of singleton to prototype
public class User {

	private int id;
	private String name;
	//@Autowired //What kind of dependency injection is this? FIELD! WE DONT LIKE FIELD INJECTION! ITS BAD!
	private Account account;
	
	//Boilerplate
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String name, Account account) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
	}
	
	
	@Autowired //What kind of dependency inject is this? CONSTRUCTOR INJECTION! WE LIKE THIS ONE!
	public User(Account account) {
		super();
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	//@Autowiring //What kind of dependency injection is this? SETTER INJECTION! WE ALSO LIKE THIS ONE! 
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		User other = (User) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + "]";
	}
	
	
}
