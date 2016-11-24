package window;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import object.FireTower;
import object.LightningTower;
import object.Player;
import object.Tower;
import object.WaterTower;
import object.WindTower;

public class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 8774272556401768353L;
	
	public Thread thread = new Thread(this);
	private int fps = 0;
	private int scene;
	private int hand = 0;
	private int handXPos = 0;
	private int handYPos = 0;
	private boolean running = false;
	
	public int towerWidth = 40;
	public int towerHeight = 40;
	
	private Player player;
	
	Frame frame;
	Tower tempTower;
	Tower lightningTower = new LightningTower();
	Tower fireTower = new FireTower();
	Tower waterTower = new WaterTower();
	Tower windTower = new WindTower();
	
	Level level;
	LevelFile levelFile;
	
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
			
			int x = 700;
			
			for(int i = 0; i < 4; i++) {
				g.setColor(Color.GREEN);
				
				g.drawRect(x, 560, 80, 80);
				
				if(i == 0) tempTower = lightningTower;
				else if(i == 1) tempTower = waterTower;
				else if(i == 2) tempTower = windTower;
				else tempTower = fireTower;
				
				g.drawImage(tempTower.getTextureFile(), x, 560, null);
				if(tempTower.cost > this.player.getMoney()) {
					g.setColor(new Color(255, 0, 0, 100));
					g.fillRect(x, 560, 80, 80);
				}
				x -= 120;
			}
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
		
		System.out.println("Width: " + this.frame.getWidth() + ", Height: " + this.frame.getHeight());
		
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
	
	public boolean isRunning() {
		return this.running;
	}
	
	public void stopRunning() {
		if(running) {
			running = false;
		}
	}
	
	public void setHandXPos(int handXPos) {
		this.handXPos = handXPos;
	}
	
	public void setHandYPos(int handYPos) {
		this.handYPos = handYPos;
	}
	
	public int getHandXPos() {
		return this.handXPos;
	}
	
	public int getHandYPos() {
		return this.handYPos;
	}
	
	public void setHand(int hand) {
		this.hand = hand;
	}
	
	public int getHand() {
		return this.hand;
	}
	
	public void setScene(int scene) {
		this.scene = scene;
	}
	
	public int getScene() {
		return this.scene;
	}
	
	public Player getPlayer() {
		return this.player;
	}
}