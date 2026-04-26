package com.gamingroom;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 *
 *represents a game containing multiple teams.
 */

public class Game extends Entity {
	
	private List<Team> teams = new ArrayList<>();
	
	public Game(long id, String name) {
		super(id, name);
	}
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	
	/**
	 * adds a new team to the game and uses the iterator pattern 
	 * to make sure the team names are unique
	 */
	
	public Team addTeam(String name) {
		/*
		 * Iterator pattern iterates through the list of teams to make sure the name 
		 * does not already exist. This prevents duplicate teams and that the client 
		 * requirement for unique names is met. 
		 */
		
		for (Team t : teams) {
			if (t.getName().equalsIgnoreCase(name)) {
				return t; //return existing team
			}
		}
		//create a new team
		Team team = new Team(GameService.getInstance().getNextTeamId(), name);
		teams.add(team);
		
		return team;
	}
	

	@Override
	public String toString() {
		
		return super.toString();
	}

}
