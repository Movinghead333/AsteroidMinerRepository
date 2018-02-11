package com.main;

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
		tiles = new MapTile[width][height];
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
		return tiles[x][y];
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
}
