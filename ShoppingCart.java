package finalHollenback;

import java.util.ArrayList;

/**
 * Object that manages the shopping cart list that deals with checkout and canceling orders
 */
public class ShoppingCart {
	private ArrayList<Saleable> currentCartList = new ArrayList<Saleable>();
	
	/**
	 * Adds to current Cart List
	 * @param s The object going into the Shopping Cart
	 */
	public void addToCart(Saleable s)
	{
		// exercise function
		System.out.println("I am in add()");		

		//add to shopping cart list with object parameter
		currentCartList.add(s);
	}
	
	/**
	 * View the current cart inventory
	 */
	public void viewCart()
	{
		System.out.println("I am in viewCart()");
	}
	
	/**
	 * Begins checkout process, prompts for confirmation
	 */
	public void checkout()
	{
		// excercise function
		System.out.println("I am in checkout()");		
	}
	
	
	
	
	
}
