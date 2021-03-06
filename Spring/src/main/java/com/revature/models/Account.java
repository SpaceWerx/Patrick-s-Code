package com.revature.models;

import org.springframework.stereotype.Component;

@Component //This is our generic annotation for making a class a Bean, and storing it in our Spring container
//It is important to note that we can use this because of ApplicationContext
public class Account {
	
	private double balance;
	private String type;

	//boilerplate code here.......................
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(double balance, String type) {
		super();
		this.balance = balance;
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", type=" + type + "]";
	}
	
}
