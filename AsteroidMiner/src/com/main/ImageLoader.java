package com.main;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageLoader {
	static URL urlLoader;
	static ImageIcon imageIconLoader;
	
	public static Image BASIC_GROUND_TILE_TEXTURE = loadImage("/basicgroundtile.png");
	public static Image BORDER_TILE_TEXTURE = loadImage("/bordertile.png");

	public static Image loadImage(String filePath) {
		
		urlLoader = GamePanel.class.getResource(filePath);
		imageIconLoader = new ImageIcon(urlLoader);
		return imageIconLoader.getImage();
	}

}