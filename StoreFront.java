package finalHollenback;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * Class with 'main' method also prints the directory menu
 */
public class StoreFront {
	
	static Inventory inv = new Inventory();
	static ShoppingCart cart = new ShoppingCart();
	/**
	 * Creates One inventory and one Cart
	 */
	private static void initializeStore()
	{
		
		
		
	}
	/**
	 * Prints the options list
	 */
	private static void printMenu() 
	{
		//print menu
		System.out.println("How would you like to proceed?");
		System.out.println("(1)View Inventory");
		System.out.println("(2)Purchase an item");
		System.out.println("(3)Cancel a Purchase");
		System.out.println("(4)Leave Store");
	}
	/**
	 * 
	 * Initial inventory within the store front
	 */
	private static void printInventory()
	{
		// print inventory
		int order = 1;
		// loop over each item
		for(Saleable item : inv.returnInventory())
		{
			// print order
			System.out.print(order + ". ");
			// print item formatted
			System.out.println(item.toString());
			// increment order
			order++;
		}


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
	 * @param args Main method arguments
	 */
	public static void main(String[] args) 
	{
		// initialize inventory
		inv.initializeInventory();
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
					printInventory();
					// prompt next step
					System.out.println("Would you like to make a purchase(Yes(1) or No(2)");
					// gather input
					input = scnr.nextInt();
					// Prompt next steps
					printMenu();
					// gather Input
					input = scnr.nextInt();
					break;
				// Make a purchase
				case 2:
					// prompt input
					System.out.println("What item would you like to purchase?");
					// print inventory
					printInventory();
					
					// gather input
					int itemIdx = scnr.nextInt();
					
					// complete purchase process
					// add purchase item to cart
					cart.addToCart(inv.purchaseItem(itemIdx - 1));
					
					// Double check if user wants to purchase
					System.out.println("Are you sure you want to add this item to your cart?");
					System.out.println("(1)Yes (2)No");
					
					// gather input
					input = scnr.nextInt();
					
					// If answer is no
					if(input == 2)
					{
						// re-add to inventory
						inv.addItem(itemIdx - 1);
						// Tell user it was taken out of cart
						System.out.println("Item has been cleared from your cart.");
						System.out.println();
					}
					else
					{
						// take added item out of cart
						cart.removeFromCart(itemIdx);
						// Update inventory and continue
						System.out.println("Great! Added to cart.");
						System.out.println();
					}
					
					
					
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
