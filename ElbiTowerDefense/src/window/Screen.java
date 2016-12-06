package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import object.CDCTower;
import object.IBSTower;
import object.LibTower;
import object.MathTower;
import object.Player;
import object.Tower;

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
	
	Graphics g;
	
	public int[][] map = new int[13][29];
	public Tower[][] towerMap = new Tower[13][29];
	public Image[] terrain = new Image[100];
	
	private Player player;
	
	private Tower tempTower;
	Tower ibsTower = new IBSTower();
	Tower cdcTower = new CDCTower();
	Tower mathTower = new MathTower();
	Tower libTower = new LibTower();
	
	Level level;
	LevelFile levelFile;
	
	Frame frame;
	
	public Screen(Frame frame) {
		this.frame = frame;
		this.frame.addKeyListener(new KeyHandler(this, this.frame));
		this.addMouseListener(new MouseHandler(this));
		this.setPreferredSize(new Dimension(1200, 500));
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
		
		if(scene == 1){
			
			//start background
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			//end background
			
			//start grid
			g.setColor(Color.CYAN);
			for(int i = 0; i < 29; i++) {
				for(int j = 0; j < 13; j++) {
					g.drawRect(20 + i*35, 20 + j*35, 35, 35);
				}
			}
			//end grid
			
			//start health and money section
			g.setColor(Color.GREEN);
			g.drawRect(1050, 20, 120, 70); //health
			g.drawString("HEALTH: ", 1055, 50);
			g.drawString(""+player.getHealth(), 1055, 70);
			
			g.setColor(Color.YELLOW);
			g.drawRect(1050, 100, 120, 70);
			g.drawString("MONEY: ", 1055, 120);
			g.drawString(""+player.getMoney(), 1055, 140);
			//end health and money section
			
			//start tower section
			
			int x = 700;
			
			for(int i = 0; i < 4; i++) {
				g.setColor(Color.GREEN);
				
				g.drawRect(x, 560, 80, 80);
				
				if(i == 0) tempTower = libTower;
				else if(i == 1) tempTower = mathTower;
				else if(i == 2) tempTower = cdcTower;
				else tempTower = ibsTower;
				
				g.drawImage(tempTower.getTextureFile(), x, 560, 80, 80,null);
				if(tempTower.cost > this.player.getMoney()) {
					g.setColor(new Color(255, 0, 0, 100));
					g.fillRect(x, 560, 80, 80);
				}
				x -= 120;
			}
		}
		
		g.setColor(Color.RED);
		g.drawString("FRAMES: " + fps, 10, 10);
	}
	
	public void startGame() {
		
		running = true;
		player = new Player(this);
		this.scene = 1;
	}
	
	public void run() {
		
		System.out.println("Width: " + this.getWidth() + ", Height: " + this.getHeight());
		
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
	
	public void setTempTower(Tower tower) {
		this.tempTower = tower;
	}
	
	public Tower getTempTower() {
		return this.tempTower;
	}
}