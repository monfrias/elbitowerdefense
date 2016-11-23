package game.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import game.objects.Tower;

public class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 8774272556401768353L;
	public Thread thread = new Thread(this);
	private int fps = 0;
	public int scene;
	public int hand = 0;
	public int handXPos = 0;
	public int handYPos = 0;
	private boolean running = false;
	Frame frame;
	Player player;
	public int towerWidth = 40;
	public int towerHeight = 40;
	
	public Screen(Frame frame) {
		this.frame  = frame;
		this.frame.addKeyListener(new KeyHandler(this));
		this.frame.addMouseListener(new MouseHandler(this));
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
		
		if(scene == 1){
			//start background
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
			//end background
			
			//start grid
			g.setColor(Color.GRAY);
			for(int i = 0; i < 29; i++) {
				for(int j = 0; j < 13; j++) {
					g.drawRect(20 + i*40, 20 + j*40, 40, 40);
				}
			}
			//end grid
			
			//start health and money section
			g.setColor(Color.GREEN);
			g.drawRect(980, 550, 200, 50); //health
			g.drawString("HEALTH: " + player.getHealth(), 1000, 580);
			
			g.setColor(Color.YELLOW);
			g.drawRect(980, 600, 200, 50);
			g.drawString("MONEY: " + player.getMoney(), 1000, 630);
			//end health and money section
			
			//start tower section
			//for loop dapat to
			g.setColor(Color.BLUE);
			g.drawImage(Tower.towerList[0].texture, 820, 560, null);
			
			if(Tower.towerList[0].cost > this.player.getMoney()) {
				g.setColor(new Color(255, 0, 0, 100));
				g.fillRect(820, 560, 80, 80);
			}
			
			g.drawRect(820, 560, 80, 80);
			
			g.setColor(Color.GREEN);
			g.drawImage(null, 700, 560, null);
			g.drawRect(700, 560, 80, 80);
			
			g.setColor(Color.YELLOW);
			g.drawImage(null, 580, 560, null);
			g.drawRect(580, 560, 80, 80);
			
			g.setColor(Color.ORANGE);
			g.drawImage(null, 460, 560, null);
			g.drawRect(460, 560, 80, 80);
			
			g.setColor(Color.RED);
			g.drawImage(null, 340, 560, null);
			g.drawRect(340, 560, 80, 80);
			//end tower section
		}
		
		g.setColor(Color.WHITE);
		g.drawString("FRAMES: " + fps, 10, 10);
	}
	
	public void startGame() {
		running = true;
		player = new Player(this);
		this.scene = 1;
	}
	
	public void run() {

		startGame();
		long lastFrame = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			repaint();
			
			frames++;
			
			if(System.currentTimeMillis()-1000 >= lastFrame) {
				fps = frames;
				frames = 0;
				lastFrame = System.currentTimeMillis();
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.exit(0);
	}
	
	public class KeyTyped {
		
		public void keyESC() {
			running = false;
		}
	}
	
	public class MouseHeld {
		boolean mouseDown = false;
		
		public void mouseDown(MouseEvent e) {
			
		}

		public void mouseMoved(MouseEvent e) {
			handXPos = e.getXOnScreen();
			handYPos = e.getYOnScreen();
		}
		
		public void updateMouse(MouseEvent e) {
			if(scene == 1) {
				if(mouseDown && hand == 0) {
					//if(e.getXOnScreen() >= frame.getWidth())
				}
			}
		}
	}
}
