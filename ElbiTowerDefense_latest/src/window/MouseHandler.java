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
		System.out.println(e.getPoint());
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
				
				//fourth tower (ibsTower)
				if(coords.getX() <= 1135 && coords.getX() >= 1055 && coords.getY() <= 470 && coords.getY() >= 390 ) {
					
					System.out.println(this.screen.getHand());
					if(this.screen.getPlayer().getMoney() >= this.screen.ibsTower.getCost()) {
						this.screen.getPlayer().setMoney(this.screen.getPlayer().getMoney() - this.screen.ibsTower.getCost());
						this.screen.setHand(1);
						this.screen.setTempTower(this.screen.ibsTower);
						System.out.println(this.screen.getHand());
					}
				}
				
				//third tower (cdcTower)
				if(coords.getX() <= 1135 && coords.getX() >= 1055 && coords.getY() <= 380 && coords.getY() >= 300 ) {
					if(this.screen.getPlayer().getMoney() >= this.screen.cdcTower.getCost()) {
						this.screen.getPlayer().setMoney(this.screen.getPlayer().getMoney() - this.screen.cdcTower.getCost());
						this.screen.setHand(1);
						this.screen.setTempTower(this.screen.cdcTower);
					}
				}
				
				//second tower (mathTower)
				if(coords.getX() <= 1135 && coords.getX() >= 1055 && coords.getY() <= 290 && coords.getY() >= 210 ) {
					if(this.screen.getPlayer().getMoney() >= this.screen.mathTower.getCost()) {
						this.screen.getPlayer().setMoney(this.screen.getPlayer().getMoney() - this.screen.mathTower.getCost());
						this.screen.setHand(1);
						this.screen.setTempTower(this.screen.mathTower);
					}
				}
				
				//first tower (libTower)
				if(coords.getX() <= 1135 && coords.getX() >= 1055 && coords.getY() <= 200 && coords.getY() >= 120 ) {
					if(this.screen.getPlayer().getMoney() >= this.screen.libTower.getCost()) {
						this.screen.getPlayer().setMoney(this.screen.getPlayer().getMoney() - this.screen.libTower.getCost());
						this.screen.setHand(1);
						this.screen.setTempTower(this.screen.libTower);
					}
				}
			}
			
//			if(this.screen.getHand() != 0) {
//				System.out.print(this.screen.getHand());
//				g.drawImage(this.screen.getTempTower().getTextureFile(), (int)coords.getX(), (int)coords.getY(), this.screen.towerWidth, this.screen.towerHeight, null);
//			}
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