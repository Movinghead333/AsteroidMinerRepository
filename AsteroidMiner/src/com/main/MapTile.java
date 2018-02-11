package com.main;

import java.awt.Image;

public abstract class MapTile {
	
	// maptile texture
	private Image texture;
	
	// collision
	private boolean collision;
	
	/**
	 * Basic constructor for a maptile
	 * 
	 * @param texture    Image which will be printed in the game
	 * @param collision  determines if the tile has collision with the player
	 */
	public MapTile(Image texture, boolean collision)
	{
		this.texture = texture;
		this.collision = collision;
	}
	
	public Image getTexture()
	{
		return texture;
	}
	
}
