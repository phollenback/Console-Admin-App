package finalHollenback;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON implements FileService
{
	// read from json file
		public ArrayList<Saleable> readData (String name)
		{
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
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// return Array List
			// likely null if returned here
			return currentInventory;
		}
		// write to json file
		public boolean writeData (String name, ArrayList<Saleable> inventory)
		{
			PrintWriter pw;
			
			try
			{
				// create a file File to write
				File file = new File(name);
				FileWriter fw = new FileWriter(file);
				pw = new PrintWriter(fw);
				
				// Write car as JSON
				ObjectMapper objectMapper = new ObjectMapper();
				String json = objectMapper.writeValueAsString(inventory);
				pw.println(json);
				
				// cleanup
				pw.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//---------------------------------------------
			// Writing to the file, inserting initial data
			//---------------------------------------------
//		PrintWriter pw;
//			
//			try {		
//				File file = new File("inventory.json");
//				
//				ObjectMapper om = new ObjectMapper();
//				om.writeValue(file, inventory);
//			} 
//			 catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
			
			//-------------------------------------------
			// DONT USE
			//-------------------------------------------
			
			return false;

		}
}
