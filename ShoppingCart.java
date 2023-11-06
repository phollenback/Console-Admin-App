package finalHollenback;

import java.util.ArrayList;

/**
 * Object that manages the shopping cart list that deals with checkout and canceling orders
 */
public class ShoppingCart {
		
	private ArrayList<Saleable> currentCartList;

	/**
	 * Creates array list of salable's for the cart
	 */
	public void initializeCart()
	{
		// initialize cart
		currentCartList = new ArrayList<Saleable>();
		
	}
	
	/**
	 * Adds a item to cart and sets its quantity
	 * @param item Item that is passed into list
	 * @param quantity Sets quantity for salable object
	 */
	public void addToCart(Saleable item, int quantity)
	{	
		// initialize variable
		boolean match = false;
		// check all items in current cart list
		for(Saleable cart : currentCartList)
		{
			// if the item passed in is already in the cart
			if(cart.getName() == item.getName())
			{
				// add the current quantity of the item with the passed in quantity
				cart.setQuantity(cart.getQuantity() + quantity);
				match = true;
			}
		}
		// if match is not true
		if(!match)
		{
			// set new quantity of added item
			item.setQuantity(quantity);
			// add to shopping cart list with object parameter
			currentCartList.add(item);
		}
		
		
	}
	
	/**
	 * Removes a item from the cart list
	 * @param idx index Index of item to remove
	 * @param quantity Amount to remove from cart
	 */
	public void removeFromCart(int idx, int quantity)  
	{
		// loop over all items
		for(Saleable item : currentCartList)
		{
			// if the index matches id
			if(item.getId() == idx)
			{
				// set proper index
				idx = item.getId() - 1;
			}
		}
		// remove number of item from cart
		currentCartList.get(idx).setQuantity(currentCartList.get(idx).getQuantity() - quantity);
		
		// check if current quantity is 0
		if(currentCartList.get(idx).getQuantity() <= 0)
		{
			// if the quantity equals 0 then remove from list
			currentCartList.remove(idx);
		}
	}
	
	/**
	 * Returns current contents of cart list
	 * @return current Cart List
	 */
	public ArrayList<Saleable> returnCart()
	{
		// if cart is empty return out print
		if(currentCartList.size() <= 0)
		{
			// return "error"
			return null;
		}
		return currentCartList;
	}
	
	
	/**
	 * Remove all contents of cart
	 */
	public void clearCart()
	{
		// clear cart
		currentCartList.clear();
	}

	
	
	
	
	
	
}
