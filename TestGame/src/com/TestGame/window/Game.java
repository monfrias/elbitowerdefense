package com.TestGame.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.TestGame.framework.ObjectId;
import com.TestGame.framework.Texture;
import com.TestGame.objects.Border;
import com.TestGame.objects.Goal;
import com.TestGame.objects.MinionRoad;
import com.TestGame.objects.Player;
import com.TestGame.objects.TowerBlock;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 367995590800308308L;
	private boolean running = false;
	private Thread thread;
	public String title;
	
	public static int WIDTH, HEIGHT;
	
	private BufferedImage level = null;
	
	Handler handler;
	static Texture texture;
	
	Random random = new Random();
	
	private void init() {
		
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		texture = new Texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/map.png"); // loading the level
		
		handler = new Handler();
		
		LoadImageLevel(level);
		
		//handler.addObject(new Player(0, 0, handler, ObjectId.Player));
		//handler.createLevel();
	}
	public synchronized void start() {
		
		if(running) return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		while(running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				
				tick();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void tick() {
		
		handler.tick();
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//start drawing
		
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		handler.render(g);
		
	
		//end drawing
		
		g.dispose();
		bs.show();
	}
	
	private void LoadImageLevel(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		int red, green, blue, pixel;
		//System.out.println("width, height: " + w + ", " + h);
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				pixel = image.getRGB(i, j);
				red = (pixel >> 16) & 0xff;
				green = (pixel >> 8) & 0xff;
				blue = (pixel) & 0xff;
				
				if(red == 0 && green == 0 && blue == 255) {
					handler.addObject(new MinionRoad(i*40, j*40, ObjectId.MinionRoad));
				}
				
				if(red == 00 && green == 255 && blue == 0) {
					handler.addObject(new TowerBlock(i*40, j*40, ObjectId.TowerBlock));
				}
				
				if(red == 255 && green == 0 && blue == 0) {
					handler.addObject(new Goal(i*40, j*40, ObjectId.Goal));
				}
				
				if(red == 255 && green == 255 && blue == 255) {
					handler.addObject(new Border(i*40, j*40, ObjectId.Border));
				}
 			}
		}
	}
	
	public static Texture getInstance() {
		
		return texture;
	}
	
	public static void main(String[] args) {
		
		new Window(1200, 600, "Sample Game", new Game());
	}
}