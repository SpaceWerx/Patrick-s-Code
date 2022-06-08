package com.revature.repositories;

import org.springframework.stereotype.Repository;

import com.revature.models.Avenger;

import java.util.Arrays;

@Repository
public class AvengerDAO {

	public static Avenger[] team = {
			(new Avenger(1, "Thor", "Thor Odinson", "HAMMER TIME", 8)),
			(new Avenger(2, "Iron Man", "Tony Stark", "BIG BRAIN BIG MONEY", 6)),	
			(new Avenger(3, "Black Widow", "Natasha Romanova", "Russian Spy", 1)),
			(new Avenger(4, "Hulk", "Bruse Banner", "ANGY GAMER RAGE", 10)),
			(new Avenger(5, "Spiderman", "Peter Parker", "HUMAN SPIDER", 5))
	};
	
	public Avenger[] getAll() {
		return team;
	}
	
	public Avenger getById(int id) {
		if(id > team.length || id < 1) {
			return null;
		}
		else {
			return team[id - 1];
		}
	}
	
	public Avenger update(Avenger a) {
		if(a.getId() > team.length || a.getId() < 1) {
			return null;
		}
		else {
			team[a.getId()-1] = a;
			System.out.println(Arrays.toString(team));
			return getById(a.getId());
		}
	}
	
}
