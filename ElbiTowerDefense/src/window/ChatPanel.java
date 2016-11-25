package window;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ChatPanel extends JPanel {
	
	public ChatPanel() {
		this.setPreferredSize(new Dimension(100, 100));
		this.setBackground(Color.red);
	}
}
