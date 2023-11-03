package finalHollenback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileService 
{
	// read from json file
	public ArrayList<Saleable> readData (String name)
	{
		ArrayList<Saleable> currentInventory = new ArrayList<Saleable>();
		try {
			// Create file out of filename passed in
			File file = new File(name);
			// Create instances for Scanner and OM
			Scanner scnr = new Scanner(file);
			// create object out of next value OM
			ObjectMapper om = new ObjectMapper();
			
			// Check if scanner has next
			while(scnr.hasNextLine())
			{
				// pass into array list
				Saleable item = om.readValue(file, Saleable.class);
				// add to array list
				currentInventory.add(item);
			}
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		// close scanner
		
		// return Array List
		return currentInventory;
		
	}
	// write to json file
	public boolean writeData (String name, ArrayList<Saleable> inventory)
	{
				
		
		//---------------------------------------------
		// Writing to the file, inserting initial data
		//---------------------------------------------
//	PrintWriter pw;
//		
//		try {		
//			File file = new File("inventory.json");
//			
//			ObjectMapper om = new ObjectMapper();
//			om.writeValue(file, inventory);
//		} 
//		 catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
		
		//-------------------------------------------
		// DONT USE
		//-------------------------------------------
		
		return false;

	}
}
