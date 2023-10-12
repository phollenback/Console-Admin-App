package finalHollenback;

import java.util.ArrayList;
/**
 * Manages the inventory of the store, keeps it all in array list of 'Saleable' objects
 */
public class Inventory {
	private ArrayList<Saleable> inventoryList = new ArrayList<Saleable>();
	
	public void initializeInventory()
	{
		// hard coded inventory
		// 2 weapons
		inventoryList.add(new Weapon("Pocket Knife","Small and Powerful.", (float)5.99, 4));
		inventoryList.add(new Weapon("Pistol","Packs a Punch.", (float)12.99, 13));
		// 2 armors
		inventoryList.add(new Armor("Head Gear","Only covers your face.", (float)17.99, 7));
		inventoryList.add(new Armor("Back Plate","You will probably win with this.", (float)79.99, 1));
		// Health
		inventoryList.add(new Health("Health Potion","Adds 50 HP.", (float)17.99, 7));
				
	}
	
	
	/**
	 * Begins purchase process
	 * @param confirm Confirms purchase
	 */
	public Saleable purchaseItem(int index)
	{
		// remove item from inventory
		removeItem(inventoryList.get(index));
		
		return inventoryList.get(index);
		
		
	}
	
	private static Saleable removeItem(Saleable item)
	{
		item.setQuantity(item.getQuantity() - 1);
		
		return item;
	}
	
	public ArrayList<Saleable> returnInventory()
	{
		return inventoryList;
	}
	
	
	/**
	 * Add item to the Inventory list
	 * @param s New item entering the inventory
	 */
	public void addItem(int index)
	{	
		// add to item quantity
		inventoryList.get(index).setQuantity(inventoryList.get(index).getQuantity() + 1);
		
	}
	
	
	
	
	
	

}
