package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Admin 
{	
	public static void main(String[] args) throws IOException 
	{
		
		System.out.println("Waiting for a client connection.......");
		ServerSocket serverSocket = new ServerSocket(6666);
		Socket clientSocket = serverSocket.accept();    
		
		// If you get here then the client is connected to the server
		System.out.println("Recieved a Client connection on port: " + clientSocket.getLocalPort());
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));     
		
		out.write("hiya");
		
		
		
		// allow input
		Scanner scnr = new Scanner(System.in);
		// gather command
		String input = scnr.next();
		// store is alive
		boolean live = true;
		// while admin is live
		while(live)
		{
			// check for command
			switch(input)
			{
				case "r":
					
					break;
					
				case "c":
					
					break;
					
				default:
					break;
			}
		}

	}
}
