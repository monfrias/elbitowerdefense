package com.TestGame.framework;

import java.awt.image.BufferedImage;

import com.TestGame.window.BufferedImageLoader;

public class Texture {
	
	SpriteSheet ss;
	private BufferedImage sprite_sheet = null;
	
	public BufferedImage[] ul_minion = new BufferedImage[3];
	public BufferedImage blocks = null;
	BufferedImageLoader loader = new BufferedImageLoader();
	
	public Texture() {
		
		try {
			sprite_sheet = loader.loadImage("/sprites.png");
			blocks = loader.loadImage("/block.png");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ss = new SpriteSheet(sprite_sheet);
		
		getTextures();
	}
	
	private void getTextures() {
		
		ul_minion[0] = loader.loadImage("/minions/ulminion1.png");
		ul_minion[1] = loader.loadImage("/minions/ulminion2.png");
		ul_minion[2] = loader.loadImage("/minions/ulminion3.png");
		
	}
}
