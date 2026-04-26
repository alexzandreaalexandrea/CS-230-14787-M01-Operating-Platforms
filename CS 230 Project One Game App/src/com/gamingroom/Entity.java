package com.gamingroom;

/**
 * Base class for all entities in the game app
 * holds common attributes like id and name
 */

public class Entity {
	
	protected long id;
	protected String name;
	
	/**
	 * constructor for making an entity with an id and name
	 */
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * return the unique identifier for the entity
	 */

	public long getId() {
		return id;
	}
	
	/**
	 * return the entity's name
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * returns a string representation of the entity
	 */
	@Override
	public String toString() {
		return String.format("%s [id=%d, name=%s]",
				this.getClass().getSimpleName(), id, name);
	}
}
