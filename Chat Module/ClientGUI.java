import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*
 * The Client with its GUI
 */
public class ClientGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	// will first hold "Username:", later on "Enter message"
	private JLabel label;
	// to hold the Username and later on the messages
	private JTextField tf;
	// to hold the server address an the port number
	private JTextField tfServer, tfPort;
	// to Logout and get the list of the users
	private JButton send;
	// for the chat room
	private JTextArea ta;
	// if it is for connection
	private boolean connected;
	// the Client object
	private Client client;
	// the default port number
	private int defaultPort;
	private String defaultHost;

	// Constructor connection receiving a socket number
	ClientGUI(String host, int port, String username) {

		super("Chat Client");
		defaultPort = port;
		defaultHost = host;



		// The TopPanel which is the chat room
		ta = new JTextArea("Welcome to the Chat room\n", 30, 30);
		JPanel northPanel = new JPanel(new GridLayout(1,1));
		northPanel.add(new JScrollPane(ta));
		ta.setEditable(false);
		add(northPanel, BorderLayout.NORTH);

		// The centerPanel with:
		JPanel centerPanel = new JPanel(new GridLayout(1,2));

		tf = new JTextField("");
		tf.setBackground(Color.WHITE);
		tf.setHorizontalAlignment(JTextField.LEFT);
		centerPanel.add(tf);

		send = new JButton("Send");
		send.addActionListener(this);
		centerPanel.add(send);
		add(centerPanel, BorderLayout.CENTER);

		// try creating a new Client with GUI
		client = new Client(host, port, username, this);
		// test if we can start the Client
		if(!client.start())
			return;

		label = new JLabel("Enter your username below", SwingConstants.CENTER);
		connected = true;
		tf.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
		tf.requestFocus();

	}

	// called by the Client to append text in the TextArea
	void append(String str) {
		ta.append(str);
		ta.setCaretPosition(ta.getText().length() - 1);
	}
	// called by the GUI is the connection failed
	// we reset our buttons, label, textfield
	void connectionFailed() {
		send.setEnabled(true);
		// don't react to a <CR> after the username
		tf.removeActionListener(this);
		connected = false;
	}

	/*
	* Button or JTextField clicked
	*/
	public void actionPerformed(ActionEvent e) {

		// ok it is coming from the JTextField
		if(connected) {
			// just have to send the message
			client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, tf.getText()));
			tf.setText("");
			tf.setHorizontalAlignment(JTextField.LEADING);
			return;
		}

	}

	// to start the whole thing the server
	public static void main(String[] args) {
		new ClientGUI(args[0], Integer.parseInt(args[1]), args[2]);
	}

}
