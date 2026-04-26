package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */



public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton 
	private static long nextTeamId = 1;
	private static long nextPlayerId = 1;

	//CODE I ADDED: THE ONLY SINGLE INSTANCE OF GameService: singleton pattern implementation
	private static GameService instance = null;
	
	/**
	 * Singleton Pattern makes sure only one instance of GameService exists. this is 
	 * important because the application must keep unique identifiers and shared state 
	 * across all games, teams, and players. The constructor is private and a static 
	 * getInstance() method is given in order to guarantee controlled access to a single shared instance.
	 */
	
	private GameService() { }
	
	public static GameService getInstance() {
		if (instance == null) {
			instance = new GameService();
		}
		return instance;
	}
	
	/**
	 * Construct a new GAME instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		//Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		//Iterator Pattern: This pattern allows me to step through the list of existing Game objects
		//one element at a time. By iterating through the list, I can search for a matching game by either
		//name or id without showing how the list is stored.
		//in this app, the iterator pattern stops duplicate games from being created and makes sure
		// I always return the correct existing instance. 
		//CODE I ADDED: iterator pattern: loop through all existing games to make sure no duplicates
		
		
		for (Game g : games) {
			if (g.getName().equalsIgnoreCase(name)) {
				return g; //return existing name
			}
		}
		
		//create a new game
		Game game = new Game(nextGameId++, name);
		games.add(game);
		
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		//Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		//Iterator Pattern: This pattern allows me to step through the list of existing Game objects
				//one element at a time. By iterating through the list, I can search for a matching game by either
				//name or id without showing how the list is stored.
				//in this app, the iterator pattern stops duplicate games from being created and makes sure
				// I always return the correct existing instance. 
		//CODE I ADDED: 
		
		for (Game g : games) {
			if (g.getId() == id) {
				return g;
			}
		}
		
		return null;
		
	}

	
	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		//Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		//Iterator Pattern: This pattern allows me to step through the list of existing Game objects
				//one element at a time. By iterating through the list, I can search for a matching game by either
				//name or id without showing how the list is stored.
				//in this app, the iterator pattern stops duplicate games from being created and makes sure
				// I always return the correct existing instance. 
		//CODE I ADDED:
		
		//iterator pattern to find game by name
		for (Game g : games) {
			if (g.getName().equalsIgnoreCase(name)) {
				return g;
			}
		}

		return null;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	//ID GENERATORS
	
	public long getNextTeamId() {
		return nextTeamId++;
	}
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
}
