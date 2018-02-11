package com.main;

import java.awt.Image;

public class TileMap2D {
	
	private MapTile[][] tiles;
	
	private final int width;
	private final int height;
	
	/**
	 * default contructor for creating
	 * @param width
	 * @param height
	 */
	public TileMap2D(int width,  int height)
	{
		this.width = width;
		this.height = height;
		
		tiles = new MapTile[height][width];
		
		for(int x = 0; x < width; x++)
		{
			tiles[0][x] = new BorderTile();
			tiles[height-1][x] = new BorderTile();
		}
		
		for(int y = 0; y < width; y++)
		{
			tiles[y][0] = new BorderTile();
			tiles[y][width-1] = new BorderTile();
		}
	}
	
	/**
	 * returns the tile at a given position
	 * 
	 * @param x int x position of tile in array
	 * @param y int y position of tile in array
	 * @return
	 */
	public MapTile getMapTileAtPosition(int x, int y)
	{
		return tiles[y][x];
	}
	
	/**
	 * adds a new tile a given position in the array
	 * 
	 * @param x xpos
	 * @param y ypos
	 * @param maptile input-tile which will be added to the map
	 */
	public void setMapTileAtPosition(int x, int y, MapTile maptile)
	{
		tiles[x][y] = maptile;
	}
	
	public Image getMapTileTexture(int x, int y)
	{
		return tiles[y][x].getTexture();
	}
}
