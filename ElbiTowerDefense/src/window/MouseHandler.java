package window;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {
	
	private Screen screen;
	private boolean mouseDown = false;
	Point coords;
	Graphics g;
	
	public MouseHandler(Screen screen) {
		this.screen = screen;
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
	
	}

	public void mousePressed(MouseEvent e) {
	
		mouseDown(e);
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
	
		this.screen.setHandXPos((int)e.getPoint().getX());
		this.screen.setHandYPos((int)e.getPoint().getY());
	}
	
	public void updateMouse(MouseEvent e) {
		//System.out.println("X-pos : " + e.getXOnScreen() + ", Y-Pos: " + e.getYOnScreen() + ", Point: " + e.getPoint());
		if(this.screen.getScene() == 1) {
			
			coords = e.getPoint();
			
			if(mouseDown && this.screen.getHand()== 0) {
				
				//first tower from the left (firetower)
				if(coords.getX() <= 423 && coords.getX() >= 343 && coords.getY() <= 666 && coords.getY() >= 586 ) {
					if(this.screen.getPlayer().getMoney() >= this.screen.fireTower.getCost()) {
						this.screen.getPlayer().setMoney(this.screen.getPlayer().getMoney() - this.screen.fireTower.getCost());
						this.screen.setHand(1);
						this.screen.setTempTower(this.screen.fireTower);
					}
				}
				
				//second tower from the left (windtower)
				if(coords.getX() <= 543 && coords.getX() >= 463 && coords.getY() <= 666 && coords.getY() >= 586 ) {
					if(this.screen.getPlayer().getMoney() >= this.screen.windTower.getCost()) {
						this.screen.getPlayer().setMoney(this.screen.getPlayer().getMoney() - this.screen.windTower.getCost());
						this.screen.setHand(1);
						this.screen.setTempTower(this.screen.windTower);
					}
				}
				
				//third tower from the left (watertower)
				if(coords.getX() <= 663 && coords.getX() >= 583 && coords.getY() <= 666 && coords.getY() >= 586 ) {
					if(this.screen.getPlayer().getMoney() >= this.screen.waterTower.getCost()) {
						this.screen.getPlayer().setMoney(this.screen.getPlayer().getMoney() - this.screen.waterTower.getCost());
						this.screen.setHand(1);
						this.screen.setTempTower(this.screen.waterTower);
					}
				}
				
				//fourth tower from the left (windtower)
				if(coords.getX() <= 783 && coords.getX() >= 703 && coords.getY() <= 666 && coords.getY() >= 586 ) {
					if(this.screen.getPlayer().getMoney() >= this.screen.lightningTower.getCost()) {
						this.screen.getPlayer().setMoney(this.screen.getPlayer().getMoney() - this.screen.lightningTower.getCost());
						this.screen.setHand(1);
						this.screen.setTempTower(this.screen.lightningTower);
					}
				}
				
				if(this.screen.getHand() != 0) {
					//g.drawImage(this.screen.getTempTower().getTextureFile(), this.screen.getHandXPos(), this.screen.getHandYPos(), this.screen.towerWidth, this.screen.towerHeight, null);
				}
			}
		}
	}
	
	public void mouseDown(MouseEvent e) {
		
		mouseDown = true;
		
		if(this.screen.getHand() != 0) {
			this.screen.setHand(0);
		}
		
		updateMouse(e);
	}
}