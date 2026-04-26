package com.gamingroom;

import  java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 * 
 * This represents a team in the game, it inherits id and name from entity
 * each team contains a list of players
 *
 *
 *represents a game containing multiple teams.
 *
 */
public class Team extends Entity {

	private List <Player> players = new ArrayList <>();
	
	/*
	 * Constructor creates a team with an identifier and name
	 */
	public Team(long id, String name) {
		super(id,name);
	}
	
	/**
	 * adds new player to the team and uses iterator pattern
	 *  to make sure player name is unique
	 */
	public Player addPlayer(String name) {
		
	
		/*
		 * Iteration pattern: iterates through the list of players to make sure the name
		 * does not already exist. This prevents duplicates and keeps data integrity in the app
		 */
		for (Player p : players) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p; //return existing player
			}
		}
		
		
		
		// create a new player using GameService ID generator
		Player player = new Player(GameService.getInstance().getNextPlayerId(), name);
		players.add(player);
		
		return player;
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
