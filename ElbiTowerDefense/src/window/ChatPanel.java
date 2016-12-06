package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatPanel extends JPanel {
	
	JTextArea messageArea;
	JScrollPane messageScroll;
	JTextField messageField;
	Frame frame;
	
	public ChatPanel(Frame frame) {
		this.frame = frame;
		this.setPreferredSize(new Dimension(500, 160));
		setBackground(Color.RED);
		
		messageArea = new JTextArea(7, 40);
		messageArea.setEditable(false);
		
		messageScroll = new JScrollPane(messageArea);
		messageScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		messageField = new JTextField(41);
		messageField.setEditable(false);
		messageField.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String message = messageField.getText();
					System.out.println(message);
					messageArea.append("me: " + message + "\n");
					messageField.setText("");
					messageField.setFocusable(false);
					messageField.setEditable(false);
					frame.requestFocus();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.add(messageScroll);
		this.add(messageField);
	}
}