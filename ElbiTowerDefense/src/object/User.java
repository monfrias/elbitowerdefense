package object;

import java.awt.Frame;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class User {

	public int portNumber;
	public String address;
	public String name;
	public Frame frame;
	public String message;
	
	//for TCP (chat)
	public Scanner scanner = new Scanner(System.in);
	public Socket client;
	
	public User(Frame frame, int portNumber, String address, String name) {
		this.portNumber = portNumber;
		this.address = address;
		this.name = name;
		this.frame = frame;
		
		try {
			client = new Socket(address, portNumber);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void looper() {
		
		Thread getInput = new Thread() {

			public void run() {
			
				while(true) {
					try {

                        InputStream inFromServer = client.getInputStream();
                        DataInputStream in = new DataInputStream(inFromServer);
                        message = in.readUTF();
                    }

                    catch(IOException e) {
                        break;
                    }
                }
            }
        };
	}
}