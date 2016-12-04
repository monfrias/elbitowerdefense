import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener {
	static Socket conn;
	JPanel panel;
	JTextField NewMsg;
	JTextArea ChatHistory;
	JButton Send;

	public ChatClient() throws UnknownHostException, IOException {
		panel = new JPanel();
		NewMsg = new JTextField();
		ChatHistory = new JTextArea();
		Send = new JButton("Send");
		this.setSize(500, 500);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(null);
		this.add(panel);
		ChatHistory.setBounds(20, 20, 450, 360);
		panel.add(ChatHistory);
		NewMsg.setBounds(20, 400, 340, 30);
		panel.add(NewMsg);
		Send.setBounds(375, 400, 95, 30);
		panel.add(Send);
		Send.addActionListener(this);
		conn = new Socket(InetAddress.getLocalHost(), 2000);

		/*
		 * for remote pc use ip address of server with function
		 * InetAddress.getByName("Provide ip here")
		 * ChatHistory.setText("Connected to Server");
		 */

		ChatHistory.setText("Connected to Server\n");
		this.setTitle("Client");
		while (true) {
			try {
				DataInputStream dis = new DataInputStream(conn.getInputStream());
				String string = dis.readUTF();
				ChatHistory.setText(ChatHistory.getText() + "Server:"
						+ string + "\n");
			} catch (Exception e1) {
				ChatHistory.setText(ChatHistory.getText()
						+ "Message sending fail:Network Error\n");
				try {
					Thread.sleep(3000);
					System.exit(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// //@Override
 //    public void keyPressed(KeyEvent e) {
 //        if (e.getKeyCode()==KeyEvent.VK_ENTER && (NewMsg.getText() != "")){
 //            ChatHistory.setText(ChatHistory.getText() + "Me:"
	// 				+ NewMsg.getText() + "\n");
	// 		try {
	// 			DataOutputStream dos = new DataOutputStream(
	// 					conn.getOutputStream());
	// 			dos.writeUTF(NewMsg.getText());
	// 		} catch (Exception e1) {
	// 			ChatHistory.setText(ChatHistory.getText()
	// 					+ "Message sending fail:Network Error\n");
	// 			try {
	// 				Thread.sleep(3000);
	// 				System.exit(0);
	// 			} catch (InterruptedException e2) {
	// 				// TODO Auto-generated catch block
	// 				e2.printStackTrace();
	// 			}
	// 		}
	// 		NewMsg.setText("");
 //        }
 //    }

 //    public void keyReleased(KeyEvent e) {
 //        if (e.getKeyCode()==KeyEvent.VK_ENTER && (NewMsg.getText() != "")){
 //            ChatHistory.setText(ChatHistory.getText() + "Me:"
	// 				+ NewMsg.getText() + "\n");
	// 		try {
	// 			DataOutputStream dos = new DataOutputStream(
	// 					conn.getOutputStream());
	// 			dos.writeUTF(NewMsg.getText());
	// 		} catch (Exception e1) {
	// 			ChatHistory.setText(ChatHistory.getText()
	// 					+ "Message sending fail:Network Error\n");
	// 			try {
	// 				Thread.sleep(3000);
	// 				System.exit(0);
	// 			} catch (InterruptedException e2) {
	// 				// TODO Auto-generated catch block
	// 				e2.printStackTrace();
	// 			}
	// 		}
	// 		NewMsg.setText("");
 //        }
 //    }

	//@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ((e.getSource() == Send) && (NewMsg.getText() != "")) {
			ChatHistory.setText(ChatHistory.getText() + "Me:"
					+ NewMsg.getText() + "\n");
			try {
				DataOutputStream dos = new DataOutputStream(
						conn.getOutputStream());
				dos.writeUTF(NewMsg.getText());
			} catch (Exception e1) {
				ChatHistory.setText(ChatHistory.getText()
						+ "Message sending fail:Network Error\n");
				try {
					Thread.sleep(3000);
					System.exit(0);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			NewMsg.setText("");
		}
	}

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		ChatClient chatForm = new ChatClient();
	}
}
