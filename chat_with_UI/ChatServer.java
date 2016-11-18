import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ChatServer {

	private ServerSocket serverSocket;
	public ArrayList<Socket> clientArray;

	public ChatServer(int port) throws IOException {

		serverSocket = new ServerSocket(port);
		clientArray = new ArrayList<Socket>();
	}

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame("Tower Defense");
		mainFrame.setPreferredSize(new Dimension(800, 600));
		mainFrame.setResizable(false);
		mainFrame.setLayout(null);
		mainFrame.setDefaultLookAndFeelDecorated(true);

		JPanel panel = new JPanel();
		panel.setBounds(5, 365, 200, 200);
		panel.setBackground(Color.blue);
		panel.setLayout(null);

		JTextArea messageArea = new JTextArea(15, 10);
		messageArea.setBackground(Color.red);
		JScrollPane messageScroll = new JScrollPane(messageArea);
		messageArea.setEditable(true);
		messageScroll.setBounds(0, 0, 199, 150);

		JTextField messageField = new JTextField("fuck you", 30);

		panel.add(messageScroll);
		panel.add(messageField);
		// mainFrame.add(messageScroll);
		// mainFrame.add(messageField);

		mainFrame.add(panel);

		mainFrame.setVisible(true);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}