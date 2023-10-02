package finalHollenback;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class with 'main' method also prints the directory menu
 */
public class StoreFront {
	
	/**
	 * Prints the options list
	 */
	private static void printMenu() 
	{
		//print menu
		System.out.println("How would you like to proceed?");
		System.out.println("(1) View Inventory");
		System.out.println("(2)Purchase an item");
		System.out.println("(3)Cancel a Purchase");
		System.out.println("(4)Leave Store");
	}
	/**
	 * Initial inventory within the store front
	 */
	private static void printInitialInv()
	{
		// new list to help out print inv
		ArrayList<Saleable> initialInv = new ArrayList<Saleable>();
		
		// hard coded inventory
		// 2 weapons
		initialInv.add(new Weapon("Pocket Knife","Small and Powerful.", (float)5.99, 4));
		initialInv.add(new Weapon("Pistol","Packs a Punch.", (float)12.99, 13));
		// 2 armors
		initialInv.add(new Armor("Head Gear","Only covers your face.", (float)17.99, 7));
		initialInv.add(new Armor("Back Plate","You will probably win with this.", (float)79.99, 1));
		// Health
		initialInv.add(new Health("Health Potion","Adds 50 HP.", (float)17.99, 7));
		
		int order = 1;
		for(Saleable s : initialInv)		
		{
			// format out print
			System.out.println(order + ". " + s.getName() + ", " + s.getDescription() + " $" + 
								s.getPrice() + ", " + s.getQuantity());
			//inc order
			order++;
		}

	}
	
	/**
	 * Begins purchase process
	 * @param confirm Confirms purchase
	 */
	private static void purchaseItem(int confirm)
	{
		// exercise function
		System.out.println("I am in purchaseItem()");	
		
	}
	/**
	 * Clears out what has been added to the cart
	 */
	private static void cancelPurchase()
	{
		// exercise function
		System.out.println("I am in cancelOrder()");		

		
	}
	
	/**
	 * Drives the program
	 * @param args Main method arguements
	 */
	public static void main(String[] args) 
	{
		// create scanner instance
		Scanner scnr = new Scanner(System.in);
		
		// welcome message
		System.out.println("Welcome to Phoenix's very own weapon store.");
		// show menu
		printMenu();
		//gather input
		int input = scnr.nextInt();
		// initialize if the store is 'live' or not
		boolean live = true;
		// While store is still 'active'
		while(live)
		{
			// check input and proceed process
			switch(input)
			{
				// view inventory
				case 1: 
					// show inventory
					printInitialInv();
					// prompt next step
					System.out.println("Would you like to make a purchase(Yes(1) or No(2)");
					// gather input
					input = scnr.nextInt();
					// Prompt next steps
					printMenu();
					// gather Input
					input = scnr.nextInt();
					break;
				case 2:
					// complete purchase process
					purchaseItem(input);	
					// Prompt next steps
					printMenu();
					// gather input
					input = scnr.nextInt();
					break;
					
				case 3:	
					// complete cancel order process
					cancelPurchase();
					// Prompt next steps
					printMenu();
					// gather input
					input = scnr.nextInt();
					break;
				case 4: 
					live = false;
					break;
			}
		}
		// Prompt goodbye statement
		System.out.println("Thanks for stopping by. Have a nice day.");
		
		
	}

}
