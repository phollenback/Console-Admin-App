package finalHollenback;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Exceptions.DataHandlingException;
import Exceptions.InventoryErrorException;
import saleable.type.Saleable;

/**
 * class that reads json files
 */
public class JSON implements FileService
{
	Socket clientSocket;
	BufferedReader in;
	PrintWriter out;

	/**
	 * Read data of input name 
	 * @throws InventoryErrorException  Problem gathering from database
	 */
	public ArrayList<Saleable> readData(String name) throws InventoryErrorException 
	{
//		try {
//			clientSocket = new Socket("127.0.0.1", 6666);
//			// Create some input and output network buffers to communicate back and forth with the Server 
//			out = new PrintWriter(clientSocket.getOutputStream(), true);
//			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//			
//		}
//		catch (IOException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String red;
//		try {
//			red = in.readLine();
//			System.out.println(red);
//		} 
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
//		
		
		
		
		
		ArrayList<Saleable> currentInventory = null;
		//open the file to read
		File file = new File(name);
			
		try
		{
			// create object mapper instance
			ObjectMapper om = new ObjectMapper();
			// read array of values from json file
			Saleable[] items = om.readValue(file, Saleable[].class);
			// convert to array list
			currentInventory = new ArrayList(Arrays.asList(items));
			// return inventory
			return currentInventory;
		}
		catch(IOException e)
		{
			// throw custom exception up to Inventory class
			throw new InventoryErrorException("ERROR: Could not gather data from Database.");
		}
	}
		
		/**
		 * Write data to source which is passed in
		 */
		public void writeData (String name, ArrayList<Saleable> inventory) throws DataHandlingException, InventoryErrorException
		{
			// Connect to the Remote Server on the specified IP Address and Port
			
			
			
			
			PrintWriter pw = null;
			
			try 
			{
				// Create file to write to
				File file = new File(name);
				FileWriter fw = new FileWriter(file);
				pw = new PrintWriter(fw);
				// om instance
				ObjectMapper mapper = new ObjectMapper();
				// write with pretty printer + string
				String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(inventory.toArray(Saleable[]::new));
				// write string
				pw.println(json);				
			}
			catch (JsonProcessingException e) 
			{
				// Unable to move to the database
				throw new DataHandlingException("ERROR: Problem converting inventory to database.");
			} 
			catch (IOException e)
			{
				// Unable to update inventory
				throw new InventoryErrorException("ERROR: Could not access database.");
			}
			finally
			{
				// close printer no matter what
				pw.close();
			}
			
			
		}
}
