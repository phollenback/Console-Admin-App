package finalHollenback;

import java.util.ArrayList;
/**
 * Manages the inventory of the store, keeps it all in array list of 'Saleable' objects
 */
public class Inventory {
	private ArrayList<Saleable> listOfSaleable = new ArrayList<Saleable>();
	
	/**
	 * formats and prints the current inventory
	 */
	public void viewInventory()
	{
		// hard code inventory
		listOfSaleable.add(new Saleable("Pocket Knife","Small and Powerful.", (float)5.99, 4));
		listOfSaleable.add(new Saleable("Bat with Spikes","Packs a Punch.", (float)12.99, 13));
		listOfSaleable.add(new Saleable("Numchucks","Useful with skill.", (float)17.99, 7));
		listOfSaleable.add(new Saleable("Katana","You will probably win with this.", (float)79.99, 1));
		
		// init. order
		int order = 1;
		for(Saleable s : listOfSaleable)		
		{
			// format out print
			System.out.println(order + "." + " " + s.getName() + " " + s.getDescription() + " $" + 
								s.getPrice() + " " + s.getQuantity());
			//inc order
			order++;
		}
	}
	
	/**
	 * Begins purchase process
	 * @param confirm Confirms purchase
	 */
	public void purchase(int confirm)
	{
		// exercise function
		System.out.println("I am in purchase()");	
		
		
	}
	
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
