// File Name GreetingServer.java

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {

    private ServerSocket serverSocket;
    public ArrayList<Socket> clientArray;

    public ChatServer(int port) throws IOException{
        //insert missing line here for binding a port to a socket
        serverSocket = new ServerSocket(port);
        //serverSocket.setSoTimeout(10000);
        clientArray = new ArrayList<Socket>();
        start();
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
            int port = Integer.parseInt(args[0]);
            new ChatServer(port);
            
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
