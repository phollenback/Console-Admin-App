package finalHollenback;

import java.io.File;
import java.util.ArrayList;
/**
 * Manages the inventory of the store, keeps it all in array list of 'Saleable' objects
 */
public class Inventory {
	
	private ArrayList<Saleable> inventoryList; 

	/**
	 * Setup inventory with multiple weapons, armor and health
	 */
	public void initializeInventory()
	{
		JSON json = new JSON();
		
		
		
		inventoryList = json.readData("inventory.json");
		
		//--------------------------------------------
		// hopefully dont need any more
//		inventoryList = new ArrayList<Saleable>();
//		// hard coded inventory
//		// 2 weapons
//		inventoryList.add(new Weapon(1,"Pocket Knife","Small and Powerful.", (float)5.99, 4));
//		inventoryList.add(new Weapon(2,"Pistol","Packs a Punch.", (float)12.99, 13));
//		// 2 armors
//		inventoryList.add(new Armor(3,"Head Gear","Only covers your face.", (float)17.99, 7));
//		inventoryList.add(new Armor(4,"Back Plate","You will probably win with this.", (float)79.99, 3));
//		// Health
//		inventoryList.add(new Health(5,"Health Potion","Holds 50 HP.", (float)17.99, 7));
		// may use again
		//---------------------------------------------
		
// 		json.writeData("inventory.json", inventoryList);
				
	}
	
	/**
	 * Remove item from Saleable quantity
	 * @param quantity Set the quantity of 
	 * @param index selected item
	 * @return New item with updated quantity
	 */
	public boolean removeItem(int index, int quantity)
	{
		// loop over all items
		for(Saleable item : inventoryList)
		{
			// if the index matches id
			if(item.getId() == index)
			{
				// set proper index
				index = item.getId() - 1;
			}
		}
		// update quantity
		inventoryList.get(index).setQuantity(inventoryList.get(index).getQuantity() - quantity);
		// if the quantity is 0 or less
		if(inventoryList.get(index).getQuantity() < 0)
		{
			// revert quantity
			inventoryList.get(index).setQuantity(inventoryList.get(index).getQuantity() + quantity);

			// show an error
			return false;
		}
		// return with no error
		return true;
	}
	
		
	/**
	 * Add item to inventory list
	 * @param index where to add items to quantity
	 * @param quantity Being manipulated at passed in index
	 */
	public void addItem(int index, int quantity)
	{	
		// loop over all items
		for(Saleable item : inventoryList)
		{
			// if the index matches id
			if(item.getId() == index)
			{
				// set proper index
				index = item.getId() - 1;
			}
		}
		// add to item quantity
		inventoryList.get(index).setQuantity(inventoryList.get(index).getQuantity() + quantity);
		
	}
	
	/**
	 * Allows access to full current inventory
	 * @return current inventory list
	 */
	public ArrayList<Saleable> getInventory()
	{
		return inventoryList;
	}
	
	

}
