package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import CustomExceptions.InventoryTranslationException;
import CustomExceptions.ServerCommunicationException;
import Sales.Saleable;

/**
 * Admin Helper class
 */
public class AdminService {
	
    private PrintWriter out;
    private BufferedReader in;
    private Socket clientSocket;

    /**
     * start the server connection
     * @throws ServerCommunicationException Problem connecting
     */
    public void start() throws ServerCommunicationException 
    {
    	// try to connect to server
        try {
        	// connect
        	clientSocket = new Socket("127.0.0.", 6666);
        	out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } 
        catch (IOException e) 
        {
        	// problem connecting to server
            throw new ServerCommunicationException("ERROR: Unable to connect to server.");
        }
    }

    /**
     * Close all resources
     * @throws ServerCommunicationException Issue closing
     */
    public void cleanup() throws ServerCommunicationException 
    {
        // check if close was successful
    	try 
    	{
    		// Close resources 
        	out.close();
			in.close();
			clientSocket.close();
		} 
    	catch (IOException e) 
    	{
			throw new ServerCommunicationException("ERROR: Unable to close server connection. Contact IT.");
		}
    }
    
    /**
     * Send a message 
     * @param msg To send
     * @return Response from server
     * @throws ServerCommunicationException Can't send message
     */
    private String sendMessage(String msg) throws ServerCommunicationException 
    {
    	// print passed in message to server
        out.println(msg);
        
        // check for issue with server connection
        try 
        {
        	// return message from server
			return in.readLine();
		} 
        catch (IOException e) 
        {
        	// throw server error if there is an issue with communication
			throw new ServerCommunicationException("ERROR: Issue communicating with the server");
		}
    }

    /**
     * R command from admin front
     * @return Array of salables
     * @throws ServerCommunicationException Issue communicating to server
     * @throws InventoryTranslationException Couldn't commit changes
     */
    public Saleable[] readCommand() throws ServerCommunicationException, InventoryTranslationException
    {
    	// initialize all variables outside of error checking
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        Saleable[] sales;
        // ==================================================
        // potential server and deserialization issue here:
        try 
        {
        	// send command to server
            json = sendMessage("r");
            // map the json returned from the server
            sales = mapper.readValue(json, Saleable[].class);
            // if successful
            // return the array of current inventory
            return sales;
        } 
        catch (ServerCommunicationException e) 
        {
        	// could not read a response from the server
            throw new ServerCommunicationException(e.getMessage());
        }
        catch (JsonProcessingException e)
        {
        	// return from the server may have issues
            throw new InventoryTranslationException("ERROR: There's an issue gathering the current inventory. Please try again shortly.");
        }
    }

    /**
     * Gather 'u' from Admin front
     * @param updateItem item to add
     * @return return success or failure message
     * @throws ServerCommunicationException Couldn't get or recieve
     * @throws InventoryTranslationException Couldn't add to inventory
     */
    public String updateCommand(Saleable updateItem) throws ServerCommunicationException, InventoryTranslationException
    {
    	// initialize variables outside of error checking
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        // check for server or inventory errors
        try 
        {
        	// write the new item as json string
            json = mapper.writeValueAsString(updateItem);
            // create command string with '|' to allow parse
            String response = sendMessage("u" + "|" + json);
            // return server response
            return response;
        } 
        catch (ServerCommunicationException e) 
        {
        	// issue communicating with server when sending message
            throw new ServerCommunicationException(e.getMessage());
        }
        catch (JsonProcessingException e) 
        {
        	// problem with admin created item
        	throw new InventoryTranslationException("ERROR: Could not add item to inventory. Please check all data you added was correct.");
        }
    }
}
