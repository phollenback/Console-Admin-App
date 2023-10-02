package finalHollenback;

import java.util.ArrayList;
/**
 * Manages the inventory of the store, keeps it all in array list of 'Saleable' objects
 */
public class Inventory {
	private ArrayList<Saleable> listOfSaleable = new ArrayList<Saleable>();
	
	
	
	
	/**
	 * Add item to the Inventory list
	 * @param s New item entering the inventory
	 */
	public void addItem(Saleable s)
	{
		// exercise function
		System.out.print("I am in addItem()");		

		// add to list 
		listOfSaleable.add(s);
	}
	/**
	 * Removes an Item from the inventory list
	 * @param index Removes an item from the specified index
	 */
	public void removeItem(int index)
	{
		// exercise function
		System.out.print("I am in removeItem()");		

		// remove at the index that is selected and passed in
		listOfSaleable.remove(index);
	}
	
	
	
	
	

}
