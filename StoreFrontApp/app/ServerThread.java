package finalHollenback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Exceptions.ClientConnectionException;
import Exceptions.InventoryErrorException;
import saleable.type.Saleable;

/**
 * Thread starter
 */
public class ServerThread extends Thread
{
	private Inventory im;
	private PrintWriter out;
	private BufferedReader in;
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public ServerThread(Inventory inv)
	{
		im = inv;
		
	}
	
	/**
	 * Close all resources
	 * @throws ClientConnectionException
	 */
	private void cleanup() throws ClientConnectionException
	{
		try 
		{
			out.close();
			in.close();
			serverSocket.close();
			clientSocket.close();
		} 
		catch (IOException e)
		{
			throw new ClientConnectionException("ERROR: Client Connection Error");
		}
	}
	
	/**
	 * Thread starter
	 */
	public void run()
	{
		try {
			// establish connection
			// --------------------------------------------------------
			// 				**CONNECTION**
			// --------------------------------------------------------
			// Accept client connection
			serverSocket = new ServerSocket(6666);
			clientSocket = serverSocket.accept();    
			// ------------connect-------------------
			// If you get here then the client is connected to the server
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));     
			// --------------------------------------------------------
			// 				CONNECTION SUCCESS VVV
			// --------------------------------------------------------
				
				
			ObjectMapper om = new ObjectMapper();
			String inputLine;
			// while the thread is receiving messages from the client
			while((inputLine = in.readLine()) != null)
			{
				// check length of input line
				if(inputLine.length() == 1)
				{
					// if command is 'r'
					if(inputLine.equals("r"))
					{
						// show that response is received
						// create current array list
						String json = om.writeValueAsString(im.getInventory().toArray(Saleable[]::new));
						// pass back to client
						out.println(json);
					}
					else if (inputLine.equals("q"))
					{
						break;
					}
					else 
						out.println("Invalid command. Please retry.");
						
				}
				else if (inputLine.length() > 1)	// input needs to be parsed
				{
					// parse string
					String[] tokens = inputLine.split("\\|");
						
					// if first part of tokens is u
					if(tokens[0].equals("u"))
					{
						// set second part to json string
						String json = tokens[1];
						// parse json side of inputLIne
						Saleable addItem = om.readValue(json, Saleable.class);
						// re do add item
						im.addNewItem(addItem);
						// echo that it worked
						out.println("Update Successful.");
					}
					
				}
					Thread.sleep(1000);
			}
			cleanup();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			
			
	}
		
}

