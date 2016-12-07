package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import object.User;

public class Frame extends JFrame{
	
	public ChatPanel chat;
	public User user;
	public Screen screen;
	
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
		
		JTextField portNumberField = new JTextField(10); 
		JTextField addressField = new JTextField(10);
		JTextField nameField = new JTextField(10);
		
		JPanel credentialsPanel = new JPanel();
		credentialsPanel.add(new JLabel("Port number: "));
		credentialsPanel.add(portNumberField);
		credentialsPanel.add(new JLabel("IP Address: "));
		credentialsPanel.add(addressField);
		credentialsPanel.add(new JLabel("Name: "));
		credentialsPanel.add(nameField);
		
		int choice = JOptionPane.showConfirmDialog(null, credentialsPanel, "Credentials Pane", JOptionPane.OK_OPTION);
		
		if(choice == JOptionPane.OK_OPTION) {
			user = new User(this, Integer.parseInt(portNumberField.getText()), addressField.getText(), nameField.getText());
		}
		
		screen = new Screen(this);
		chat = new ChatPanel(this, user);
		this.add(screen);
		this.add(chat);
		this.pack();
		
	}
}