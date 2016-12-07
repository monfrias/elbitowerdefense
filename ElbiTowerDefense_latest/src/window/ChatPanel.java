package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.io.IOException;
//import java.net.Socket;
//import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import object.User;

import java.net.*;
import java.io.*;

public class ChatPanel extends JPanel {
	
	JTextArea messageArea;
	JScrollPane messageScroll;
	JTextField messageField;
	Frame frame;
	User user;
	
	public Scanner scanner = new Scanner(System.in);
	public Socket client;
	
	public ChatPanel(Frame frame, User user) {
		this.user = user;
		this.frame = frame;
		
		try {
			client = new Socket(this.user.address, this.user.portNumber);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setPreferredSize(new Dimension(500, 160));
		setBackground(Color.BLACK);
		
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
					//String message = messageField.getText();
					//System.out.println(message);
					//messageArea.append("me: " + message + "\n");
					try {
						sendMessage();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
	
	 public void looper() {

        Thread getInput = new Thread() {

            public void run() {

                while(true) {
                    try {

                        InputStream inFromServer = client.getInputStream();
                        DataInputStream in = new DataInputStream(inFromServer);
//                      System.out.println(in.readUTF());
                        messageArea.append(in.readUTF());
                    }

                    catch(IOException e) {
                        break;
                    }
                }
            }
        };

        getInput.start();
    }
	 
	 public void sendMessage() throws IOException{

        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);


            String message = messageField.getText();

            if(!message.equals("")) {
            	out.writeUTF(user.name + " : " + message);
            	messageArea.append("me: " + message + "\n");
            }

	 }
}