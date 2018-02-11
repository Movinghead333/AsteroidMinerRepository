package com.main;

public class Player {
	
	private int xTileCoord;
	private int yTileCoord;
	
	public Player(int xTileCoord, int yTileCoord)
	{
		this.xTileCoord = xTileCoord;
		this.yTileCoord = yTileCoord;
	}
	
	public int getXTileCoord()
	{
		return xTileCoord;
	}
	
	public int getYTileCoord()
	{
		return yTileCoord;
	}
}
