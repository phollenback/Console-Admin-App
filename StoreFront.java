package finalHollenback;

import java.util.Scanner;
/**
 * Class with 'main' method also prints the directory menu
 */
public class StoreFront {
	static Inventory inv = new Inventory();
	static ShoppingCart cart = new ShoppingCart();
	static Scanner scnr = new Scanner(System.in);
	
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
	
	private static void allowPurchase()
	{
		System.out.println("What item would you like to purchase?");
	}
	
	/**
	 * Drives the program
	 * @param args Main method arguements
	 */
	public static void main(String[] args) {
		//welcome message
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
				// Purchase an object
				case 1: 
					// show inventory
					inv.viewInventory();
					// prompt a purchase
					allowPurchase();
					// gather input
					input = scnr.nextInt();
					// Prompt next steps
					printMenu();
					// gather Input
					input = scnr.nextInt();
					break;
				case 2:
					// complete purchase process
					inv.purchase(input);	
					// Prompt next steps
					printMenu();
					// gather input
					input = scnr.nextInt();
					break;
					
				case 3:	
					// complete cancel order process
					cart.cancelOrder();
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
