package game.window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {
	
	private Screen screen;
	private boolean mouseDown = false;
	
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
	
		this.screen.setHandXPos(e.getXOnScreen());
		this.screen.setHandYPos(e.getYOnScreen());
	}
	
	public void updateMouse(MouseEvent e) {
		System.out.println("X-pos : " + e.getXOnScreen() + ", Y-Pos: " + e.getYOnScreen());
		if(this.screen.getScene() == 1) {
			if(mouseDown && this.screen.getHand()== 0) {
				if(e.getXOnScreen() <= 968 && e.getXOnScreen() >= 825 && e.getYOnScreen() <= 665 && e.getYOnScreen() >= 585 ) {
					System.out.println("Tower CLICKED!");
					this.screen.setHand(1);
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
