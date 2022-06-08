package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Avenger {

	private int id;
	private String heroName;
	private String realName;
	private String power;
	private int powerLevel;

	//Boilerplate Code
	public Avenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avenger(int id, String heroName, String realName, String power, int powerLevel) {
		super();
		this.id = id;
		this.heroName = heroName;
		this.realName = realName;
		this.power = power;
		this.powerLevel = powerLevel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getPowerLevel() {
		return powerLevel;
	}
	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((heroName == null) ? 0 : heroName.hashCode());
		result = prime * result + id;
		result = prime * result + ((power == null) ? 0 : power.hashCode());
		result = prime * result + powerLevel;
		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
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
		Avenger other = (Avenger) obj;
		if (heroName == null) {
			if (other.heroName != null)
				return false;
		} else if (!heroName.equals(other.heroName))
			return false;
		if (id != other.id)
			return false;
		if (power == null) {
			if (other.power != null)
				return false;
		} else if (!power.equals(other.power))
			return false;
		if (powerLevel != other.powerLevel)
			return false;
		if (realName == null) {
			if (other.realName != null)
				return false;
		} else if (!realName.equals(other.realName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Avenger [id=" + id + ", power=" + power + ", heroName=" + heroName + ", realName=" + realName
				+ ", powerLevel=" + powerLevel + "]";
	}
	
	
}
