package com.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	// Window width and height
	private final int B_WIDTH = 1024;
	private final int B_HEIGHT = 768;
	
	// Amount of tiles in x and y direction
	public final int MAP_X = 50;
	public final int MAP_Y = 50;
	
	// Animating thread
	private Thread animator;
	
	// Player object
	private Player player;
	
	// Map object which holds the 2d array for the maptiles
	private TileMap2D map;
	
	
	
	private int xTileOffset;
	private int yTileOffset;
	
	
	//private Player player;
	private Point mouse = new Point();
	
	private int xOffset = 16;
	private int yOffset = 16;

	// test
	BasicGroundTile bgt = new BasicGroundTile();
	
	
	
	/**
	 * Contructor used for the creation of the game instance
	 */
	public GamePanel()
	{
		initBoard();
	}
	
	/**
	 * Method that initializes the game
	 */
	private void initBoard()
	{
		
		// Set game-panel properties
		setDoubleBuffered(true);
        setFocusable(true);
        requestFocusInWindow();
		addKeyListener(this);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		
		// player initialisation
		player = new Player(10, 10);
		
		// map initialisation
		map = new TileMap2D(MAP_X, MAP_Y);


		//player = new Player((MAP_X / 2), (MAP_Y / 2), PLAYER_PATH, this);
		
		// Add mouse-listener
		addMouseListener(new MouseAdapter()
		{
        	public void mousePressed(MouseEvent me)
        	{
        		mouseClick(me);
        	}
        });
		
		// Add mouse-motion-listener
		addMouseMotionListener(new MouseAdapter()
		{
        	public void mouseMoved(MouseEvent me)
        	{
        		mouseMove(me);
        	}
		});
	}

	protected void mouseClick(MouseEvent me)
	{
		//player.mouseClicked(me);
	}
	
	protected void mouseMove(MouseEvent me)
	{
		mouse.x = me.getX();
		mouse.y = me.getY();
		//player.mouseMoved(me);
	}

	/**
	 * Method that start the gamethread
	 */
	@Override
	public void addNotify()
	{
		super.addNotify();
		
		animator = new Thread(this);
		animator.start();
	}

	/**
	 * Drawmethod from the supertype
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bgt.getTexture(), 0, 0,  this);
		renderGame(g);
		//player.render(g);
	}
	
	private void renderGame(Graphics g) {
		
		// determine the xTileOffset based on player position
		int xoffset = 0;
		if(player.getXTileCoord() > ((B_WIDTH / 32) / 2) ) // compare xTileCoord to see if its in the "middle area"
		{
			xoffset = player.getXTileCoord() - ((B_WIDTH / 32) / 2);
		}
		//else if()  //TODO
		
		for(int y = 0; y < (1 + (B_HEIGHT)); y++)
		{
			for(int x = 0; x < (1 + (B_WIDTH)); x++)
			{
				// g.drawImage(map, x, y, observer) TODO
			}
		}
		
		
		//old render
		/*
		for(int x = 0; x < 33; x++){
			for(int y = 0; y < 25; y++){
				g.drawImage(map.getTile(xTileOffset + x, yTileOffset + y).getTexture(),
						(xOffset + (x * 32)), (yOffset + (y * 32)), this);
			}
		}
		*/
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void tick()
	{
		// old tile update function
		/* 
		if (player.getxTileCoord() > 15 && player.getxTileCoord() < MAP_X-16){
			xTileOffset = player.getxTileCoord() - 16;
			xOffset = -16;
		}else if(player.getxTileCoord() <= 15){
			xTileOffset = 0;
			xOffset = 16;
		}else if(player.getxTileCoord() >= MAP_X - 16){ //TODO: evtl nur else
			xTileOffset = MAP_X - 33;
			xOffset = -48;
		}
		if (player.getyTileCoord() > 11 && player.getyTileCoord() < MAP_Y-12){
			yTileOffset = player.getyTileCoord() - 12;
			yOffset = -16;
		}else if(player.getyTileCoord() <= 11){
			yTileOffset = 0;
			yOffset = 16;
		}else if(player.getyTileCoord() >= MAP_Y - 12){ //TODO: evtl nur else
			yTileOffset = MAP_Y - 25;
			yOffset = -48;
		}
		*/
		
	}
	
	/**
	 * Method that gets updated 40 times a second and takes over updating values
	 */
	private void cycle()
	{
		tick();
		//player.tick();
	}
	
	/**
	 * Method which is running the actual Game
	 */
	@Override
	public void run()
	{
		
		long beforeTime, timeDiff, sleep;
		
		beforeTime = System.currentTimeMillis();
		
		while(true) {
			cycle();
			repaint();
			
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = 25 - timeDiff;
			
			if (sleep < 0) {
				sleep = 2;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted:  "+ e.getMessage());
			}
			
			beforeTime = System.currentTimeMillis();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		//player.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		//player.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	/*
	public Map2D getMap()
	{
		return map;
	}
	*/
	
	public Point getMouse()
	{
		return mouse;
	}
}
