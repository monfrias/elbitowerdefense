package window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
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
		//this.setExtendedState(MAXIMIZED_BOTH);
		this.pack();
		
		Screen screen = new Screen(this);
		this.add(screen);
	}
}