package finalHollenback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Exceptions.DataHandlingException;
import Exceptions.InventoryErrorException;
import saleable.type.Saleable;

/**
 * Class with 'main' method also prints the directory menu
 */
public class StoreFront {
	
	private	Inventory inv;
	private ShoppingCart cart;
	private ServerThread thread;

	/**
	 * Initializes the objects used in the store
	 * @throws DataHandlingException 
	 */
	private void initializeStore()
	{
		// create Inventory and cart and begin thread
		inv = new Inventory();
		cart = new ShoppingCart();
		thread = new ServerThread();
		// run thread
		thread.run();
		// initialize each list
		try
		{
			// trys to gather inventory
			inv.initializeInventory();
		}
		catch(InventoryErrorException e)
		{
			// problem gathering inventory
			System.out.println(e.getMessage());
		}
		cart.initializeCart();
	}
	
	/**
	 * Prints the options list
	 */
	private void printMenu() 
	{
		//print menu
		System.out.println("How would you like to proceed?");
		System.out.println("(1)View current Inventory");
		System.out.println("(2)Purchase an item");
		System.out.println("(3)Cancel a purchase");
		System.out.println("(4)View Cart");
		System.out.println("(5)Clear Cart");
		System.out.println("(6)Leave Store");
	}
	/**
	 * Process of printing, sorting, and updating list id's
	 * @param list ArrayList from inventory or shopping cart
	 */
	private void printList(ArrayList<Saleable> list)
	{
		// if nothing is passed in
		if(list == null)
		{
			// print error
			System.out.println("Cart is Empty!");
		}
		else
		{
			// sort before printing / ASC
			Collections.sort(list);
			// DESC
		//	Collections.reverse(list);
			// initialize array order
			int order = 1;
			// loop over each item
			for(Saleable item : list)
			{
				// set id according to order
				item.setId(order);
				// print item formatted
				System.out.println(item.toString());
				// increment order
				order++;
			}
			
		}
	}
	
	/**
	 * Begins purchase item process
	 */
	private void purchaseItem()
	{
		Scanner scnr = new Scanner(System.in);
		// get inventory
		ArrayList<Saleable> currentInv = inv.getInventory();
		
		// prompt user input
		System.out.println("What item would you like to purchase?");
		// print inventory
		printList(currentInv);
		// gather which item
		int itemIdx = scnr.nextInt();
		// Ask for quantity
		System.out.println("How many would you like to purchase?");
		// gather quantity
		int quantity = scnr.nextInt();
		// Double check if user wants to purchase
		System.out.println("Are you sure you want to add this item to your cart? (1)Yes (2)No");
		// gather input
		int input = scnr.nextInt();
		
		// If answer is no
		if(input == 2)
		{
			// acknowledge decision
			System.out.println("No problem.");
		}
		// If answer is yes, remove item and add to cart
		else
		{		
			try 
			{
				// pass into cart with cloned item from remove item
				cart.addToCart(inv.removeItem(itemIdx, quantity), quantity);
				// Update inventory and continue
				System.out.println("Great! Added to cart.");
				System.out.println();
			}
			catch(DataHandlingException e)
			{
				System.out.println(e.getMessage());
				// restart the process
				purchaseItem();
			}
		}	
	}
	/**
	 * Cancel a purchase from the cart
	 */
	private void cancelPurchase()
	{
		Scanner scnr = new Scanner(System.in);
		
		// Ask which item they are cancelling
		System.out.println("What would you like to cancel?");
		// print options
		printList(cart.returnCart());
		// gather id number
		int idx = scnr.nextInt();
		// how many are they cancelling
		System.out.println("How many would you like to remove?");
		// gather input
		int quantity = scnr.nextInt();
			
		// remove number of items from cart
		cart.removeFromCart(idx,quantity);
			
		// add to inventory
		inv.addItem(idx, quantity);
		
	}
	
	/**
	 * Drives the program
	 * @param args Main method arguments
	 */
	public static void main(String[] args)
	{		
		// Create scanner
		Scanner scnr = new Scanner(System.in);
		// Create store front to eliminate static
		StoreFront store = new StoreFront();
		// initialize store
		store.initializeStore();
		// welcome message
		System.out.println("Welcome to Phoenix's very own weapon store.");
		// show menu
		store.printMenu();
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
					// print inventory
					store.printList(store.inv.getInventory());
					// Prompt next steps
					store.printMenu();
					// gather Input
					input = scnr.nextInt();
					break;
				// Make a purchase
				case 2:
					// start purchase process
					store.purchaseItem();
					// prompt next step
					store.printMenu();
					// gather next menu option
					input = scnr.nextInt();
					break;
				// cancel purchase
				case 3: 
					// begin cancel process
					store.cancelPurchase();
					// prompt next step
					store.printMenu();
					// gather next menu option
					input = scnr.nextInt();
					break;
			    // view cart
				case 4:
					// print cart
					store.printList(store.cart.returnCart());
					// prompt next step
					store.printMenu();
					// gather next menu option
					input = scnr.nextInt();
					break;
				// clear cart
				case 5:
					// clear cart
					store.cart.clearCart();
					// print list to check if null
					store.printList(store.cart.returnCart());
					// print menu
					store.printMenu();
					// gather next menu option
					input = scnr.nextInt();
					break;
				// leave store
				case 6:
					try 
					{
						// save back to file
						store.inv.saveInventory();
					} 
					catch (DataHandlingException e)
					{
						System.out.println(e.getMessage());
					}
					catch(InventoryErrorException e)
					{
						System.out.println(e.getMessage());
					}
					// breaks store
					live = false;
					break;
			}
		}
		// Prompt goodbye statement
		System.out.println("Thanks for stopping by. Have a nice day.");
		
		
	}

}
