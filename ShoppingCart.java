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
	public void addToCart(Saleable item)
	{
		// exercise function
		System.out.println("I am in addToCart()");		

		//add to shopping cart list with object parameter
		currentCartList.add(item);
	}
	
	/**
	 * remove added item from cart
	 * @param itemIdx Specified item to remove
	 */
	public void removeFromCart(int itemIdx) 
	{
		// remove item from cart
		currentCartList.remove(itemIdx);
	}
	
	/**
	 * View the current cart inventory
	 */
	public void viewCart()
	{
		System.out.println("I am in viewCart()");
	}
	
	

	
	
	
	
	
	
}
