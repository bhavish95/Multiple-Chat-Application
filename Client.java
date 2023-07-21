package com.bhavish.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.bhavish.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker worker;
	JTextArea textArea;
	
	public Client(JTextArea textArea) throws UnknownHostException,IOException {
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket=new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		out=socket.getOutputStream();
		in=socket.getInputStream();
		this.textArea=textArea;
		readMessage();
		
		
		
	//	System.out.println("Client Comes");
		//System.out.println("Enter the Message Send to the Server....");
	//	Scanner sc=new Scanner(System.in);
//		String message=sc.nextLine();
	//	OutputStream out=socket.getOutputStream();
	//	out.write(message.getBytes());//write bytes on network
	//	System.out.println("Message send to the Server");
	//	sc.close();
	//	out.close();
	//	socket.close();
	}
	
	public void sendMessage(String message)throws IOException{
		message=message+"\n";
		out.write(message.getBytes());
	}
    
	public void readMessage() {
		worker=new ClientWorker(in,textArea);// calling the read thread
		worker.start();
	}
	//public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
    // Client client=new Client();
	//}

}
