package app;

import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import CustomExceptions.InventoryTranslationException;
import CustomExceptions.ServerCommunicationException;
import Sales.Armor;
import Sales.Health;
import Sales.Saleable;
import Sales.Weapon;

/**
 * Admin main method
 */
public class Admin 
{	
	private AdminService ser;
	
	/**
	 * initialize server connection
	 */
	public void initializeService()
	{
		// handles commands and connection
		ser = new AdminService();
		// establish connection
		try
		{
			ser.start();
		}
		catch(ServerCommunicationException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * print options
	 * @return scanner 
	 */
	private String printMenu()
	{
		Scanner scnr = new Scanner(System.in);
		// print menu
		System.out.println();
		System.out.println("Would you like to: ");
		System.out.println("(r) Read the data, (u) Update the data, or (q) Quit.");
		// gather input
		String input = scnr.next();
		// return input
		return input;
	}
	
	/**
	 * Gather salable item
	 * @return New Salable
	 */
	private Saleable gatherNewItem() 
	{
		// gather
		Scanner scnr = new Scanner(System.in);
		
		// prompt response on type
		System.out.println("Is your new item a (1) Weapon, (2) Armor, or (3) Health");
		// set type
		int type = scnr.nextInt();
		
		// prompt name
		System.out.println("What's the name of the item?");
		String name = scnr.next();	
		// prompt description
		System.out.println("Give a brief description of the item.");
		String desc = scnr.next();
		// prompt price
		System.out.println("Give your item a price.");
		float price = scnr.nextFloat();
		scnr.nextLine();
		// prompt quantity
		System.out.println("What's your item's quantity?");
		int quan = scnr.nextInt();
		
		
		// initialize new item
		Saleable newItem = null;
		// check for type of salable
		if(type == 1)
			newItem = new Weapon(99,name, desc, price, quan);		// make new weapon
		else if (type == 2)
			newItem = new Armor(99, name, desc, price, quan);		// make new armor
		else if (type == 3) 
			newItem = new Health(99, name, desc, price, quan);		// make new health
		
		// return item with meta data
		return newItem;
	}

	/**
	 * Main Driver
	 * @param args The usual
	 * @throws IOException Connection
	 */
	public static void main(String[] args) throws IOException 
	{
		// eliminate static
		Admin admin = new Admin();
		// initialize things needed / establish connection
		admin.initializeService();		
		// allow input
		Scanner scnr = new Scanner(System.in);
		// gather command
		System.out.println("Good day Mr. Admin! What can we do for you today?");
		// prompt user input
		String input = admin.printMenu();
		// store is alive
		boolean live = true;
		// while admin is live
		while(live)
		{
			// check for command
			switch(input)
			{
				// read command
				case "r":
					try
					{
						// gather inventory from service
						Saleable[] sales = admin.ser.readCommand(); 
						// header for inventory
						System.out.println("CURRENT INVENTORY:");
						// print inventory
						for(Saleable s : sales)
						{
							// to string each salable
							System.out.println(s.toString());
						}
					}
					catch(ServerCommunicationException | InventoryTranslationException e)
					{
						// print error thrown by either exception
						System.out.println(e.getMessage());
					} 
					// prompt for next steps
					input = admin.printMenu();
					
					break;
				// update command
				case "u":
					// gather new item
					Saleable updateItem = admin.gatherNewItem();
					// check for server or inventory error
					try 
					{
						// update the inventory in the store front with gathered item
						String response = admin.ser.updateCommand(updateItem);
						System.out.println("SERVER RESPONSE: " + response);
					} 
					catch (ServerCommunicationException | InventoryTranslationException e)
					{
						// print error message for either exception
						System.out.println(e.getMessage());
					}
					// prompt next steps
					input = admin.printMenu();
					break;
				// quit command
				case "q":
					// shutdown store
					live = false;
					// check if cleanup is successful
					try 
					{
						// cleanup all connections / resources
						admin.ser.cleanup();
					}
					catch(ServerCommunicationException e)
					{
						// if unable to close echo to admin
						System.out.println(e.getMessage());
					}
					
				default:
					break;
			}
		}
		// store experience close
		System.out.println("Thanks. We will take it from here.");

	}


	
}
