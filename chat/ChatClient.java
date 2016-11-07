import java.net.*;
import java.io.*;
import java.util.*;

public class ChatClient{

    public Socket client;
    public Scanner scanner = new Scanner(System.in);

    public ChatClient(String serverName, int port) {
        try {

            client = new Socket(serverName, port);
            looper();
            sendMessage();
        }

        catch(IOException e) {
        }
    }

    public static void main(String [] args){
        try{
            String serverName = args[0]; //get IP address of server from first param
            int port = Integer.parseInt(args[1]); //get port from second param
            //         
            new ChatClient(serverName, port);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Usage: java GreetingClient <server ip> <port no.> '<your message to the server>'");
        }
    }

    public void looper() {

        Thread getInput = new Thread() {

            public void run() {

                while(true) {
                    try {
                     
                        InputStream inFromServer = client.getInputStream();
                        DataInputStream in = new DataInputStream(inFromServer);
                        System.out.println(in.readUTF());
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

        while(true) {

            String message = scanner.nextLine();

            if(message.equals("")) continue;

            out.writeUTF("Client " + client.getLocalSocketAddress()+" says: " + message);
        }
    }
}