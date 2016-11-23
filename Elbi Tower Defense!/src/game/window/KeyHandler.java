package game.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	private Screen screen;
	private Screen.KeyTyped keyTyped;
	
	public KeyHandler(Screen screen) {
		this.screen = screen;
		this.keyTyped = this.screen.new KeyTyped();
		
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_ESCAPE) {
			this.keyTyped.keyESC();
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
}
