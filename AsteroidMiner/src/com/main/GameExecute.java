package com.main;

import java.awt.EventQueue;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameExecute extends JFrame {

	// Game-instance
	public static GamePanel game;
	
	
	/**
	 *  Constructor for game-execution
	 */
	public GameExecute() {
		initUI();
	}
	
	/**
	 *  Method for initialising the window properties
	 */
	private void initUI() {
		game = new GamePanel();
		add(game);
		
		setResizable(false);
		pack();
		
		setTitle("Asteoid Miner 0.0");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/** main-method launching the game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame ex = new GameExecute();
				ex.setVisible(true);
			}
		});
	}
}
