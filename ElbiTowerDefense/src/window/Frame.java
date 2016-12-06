package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	ChatPanel chat;
	
	public static void main(String[] args) {
		
		new Frame();
	}
	
	public Frame() {
		new JFrame();
		this.setPreferredSize(new Dimension(1200, 700));
		this.setTitle("Elbi Tower Defense!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.getContentPane().setBackground(Color.BLACK);
		
		Screen screen = new Screen(this);
		chat = new ChatPanel(this);
		this.add(screen);
		this.add(chat);
		
		this.pack();
	}
}