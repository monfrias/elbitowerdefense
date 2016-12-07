package window;
// File Name GreetingServer.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatServer {

    private ServerSocket serverSocket;
    public ArrayList<Socket> clientArray;

    public ChatServer() throws IOException{
        //insert missing line here for binding a port to a socket
        
        //serverSocket.setSoTimeout(10000);
        clientArray = new ArrayList<Socket>();
        
        JTextField portNumberField = new JTextField(10);
        
        JPanel credentialsPanel = new JPanel();
		credentialsPanel.add(new JLabel("Port number: "));
		credentialsPanel.add(portNumberField);
		
		int choice = JOptionPane.showConfirmDialog(null, credentialsPanel, "Credentials Pane", JOptionPane.OK_OPTION);
        
		if(choice == JOptionPane.OK_OPTION) {
			serverSocket = new ServerSocket(Integer.parseInt(portNumberField.getText()));
			start();
		}
		
		
    }

    public void start(){
        boolean connected = true;
        while(connected){
            try{
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket client = serverSocket.accept(); //waits
                clientArray.add(client);
                looper(client);
                System.out.println("Just connected to " + client.getRemoteSocketAddress());
            }
            catch(IOException e){
                e.printStackTrace();
                System.out.println("Input/Output Error!");
                //possible cause: client was disconnected while waiting for input
                break;
            }
        }
    }

    public static void main(String [] args){
        try{
            
            new ChatServer();

        }catch(IOException e){
            //e.printStackTrace();
            System.out.println("Usage: java GreetingServer <port no.>\n"+
                    "Make sure to use valid ports (greater than 1023)");
        }catch(ArrayIndexOutOfBoundsException e){
            //e.printStackTrace();
            System.out.println("Usage: java GreetingServer <port no.>\n"+
                    "Insufficient arguments given.");
        }
    }

    public void looper(Socket client) {

        Thread getInput = new Thread() {

            public void run() {

                try {

                    DataInputStream in = new DataInputStream(client.getInputStream());
                    String input;

                    while(true) {


                        input = in.readUTF();
                        sendMessage(input);
                        System.out.println(input);

                    }
                }

                catch(IOException e) {

                }
            }
        };

        getInput.start();
    }

    public void sendMessage(String message) throws IOException{
        for(Socket c : clientArray) {
            DataOutputStream out = new DataOutputStream(c.getOutputStream());
            out.writeUTF(message);
        }
    }
}
