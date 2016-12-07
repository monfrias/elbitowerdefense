import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChatClient {
	
	public static JFrame frame;
	public static Container c;
	public static void main(String[] args) {
		
		int status = 0;
		
		frame = new JFrame("Chat Client!");
		frame.setPreferredSize(new Dimension(300, 365));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		c = frame.getContentPane();
		
		if(status == 0) status = askCredentials();
		
		frame.pack();
	}
	
	public static int askCredentials() {
		
		JTextField nameField = new JTextField();
		nameField.setBounds(50, 50, 200, 25);
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(130, 70, 200, 25);
		
		JTextField serverField = new JTextField();
		serverField.setBounds(50, 100, 200, 25);
		JLabel serverLabel = new JLabel("Server name");
		serverLabel.setBounds(110, 120, 200, 25);
		
		JTextField portField = new JTextField();
		portField.setBounds(50, 150, 200, 25);
		JLabel portLabel = new JLabel("Port label");
		portLabel.setBounds(115, 170, 200, 25);
		
		
		JButton chatTrigger = new JButton("CHAT!");
		chatTrigger.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String server = serverField.getText();
				int port = Integer.parseInt(portField.getText());
			}
		});
		chatTrigger.setBounds(90, 250, 100, 30);
		
		c.add(nameField);
		c.add(nameLabel);
		c.add(serverField);
		c.add(serverLabel);
		c.add(portField);
		c.add(portLabel);
		c.add(chatTrigger);
		
		return 1;
	}
}