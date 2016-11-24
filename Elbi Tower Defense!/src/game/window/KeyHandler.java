package game.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	private Screen screen;
	private boolean running;
	
	public KeyHandler(Screen screen) {
		this.screen = screen;		
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_ESCAPE) {
			running = this.screen.isRunning();
			
			if(running) {
				this.screen.stopRunning();
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
}
