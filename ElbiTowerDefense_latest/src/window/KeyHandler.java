package window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	private Screen screen;
	private Frame frame;
	private boolean running;
	
	public KeyHandler(Screen screen, Frame frame) {
		this.screen = screen;
		this.frame = frame;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_ESCAPE) {
			running = this.screen.isRunning();
			
			if(running) {
				this.screen.stopRunning();
			}
		}
		
		else if(keyCode == KeyEvent.VK_ENTER) {
			
			if(this.frame.chat.messageField.getText().isEmpty()) {
				this.frame.chat.messageField.setFocusable(true);
				this.frame.chat.messageField.setEditable(true);
				this.frame.chat.messageField.requestFocus();
			}
			
			else {
				String message = this.frame.chat.messageField.getText();
				System.out.println(message);
				this.frame.chat.messageArea.append("me: " + message + "\n");
				this.frame.chat.messageField.setText("");
				this.frame.chat.messageField.setFocusable(false);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
}