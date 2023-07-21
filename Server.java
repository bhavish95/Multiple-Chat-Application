package com.bhavish.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.bhavish.chatapp.utils.ConfigReader;

public class Server {
       ServerSocket serverSocket;
       ArrayList<ServerWorker>workers=new ArrayList<>();//contains all the client sockets
       
       public Server() throws IOException {
    	   int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
    	   serverSocket=new ServerSocket(PORT);
    	   System.out.println("Server Starts and waiting for clients joins the server");
    	   handleClientRequest();
       }
       //Multiple client Handshaking
       public void handleClientRequest() throws IOException {
    	   while(true) {
    	   Socket clientSocket=serverSocket.accept();//Handshaking
    	   //per client per thread
    	   ServerWorker serverWorker=new ServerWorker(clientSocket,this);//creating a new wroker
           workers.add(serverWorker);
    	   serverWorker.start();
    	   
       }
     }
       
       
       //single client
       /*
       public Server() throws IOException {
    	   int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
    	   serverSocket=new ServerSocket(PORT);
    	   System.out.println("Server Started and waiting for the client Connection ....");
    	   Socket socket=serverSocket.accept();//Handshaking process
    	   System.out.println("Client Joins the Server");
    	  InputStream in= socket.getInputStream();//read bytes from the network
    	  byte arr[]=in.readAllBytes();
    	  String str=new String(arr);//bytes convert into string
    	  System.out.println("Message Rec From clinet"+str);
    	  in.close();
    	   socket.close();
       }*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    Server server=new Server();
	}

}
