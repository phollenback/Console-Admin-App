package finalHollenback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Exceptions.DataHandlingException;
import Exceptions.InventoryErrorException;
import saleable.type.Armor;
import saleable.type.Health;
import saleable.type.Saleable;
import saleable.type.Weapon;
/**
 * Manages the inventory of the store, keeps it all in array list of 'Saleable' objects
 */
public class Inventory {
	
	private ArrayList<Saleable> inventoryList; 

	/**
	 * Setup inventory with multiple weapons, armor and health
	 * @throws InventoryErrorException Can't gather data from database
	 * @throws DataHandlingException 
	 */
	public void initializeInventory() throws InventoryErrorException
	{
		// file service instance
		JSON json = new JSON();
		
		try
		{
			// gather data from external json
			inventoryList = json.readData("inventory.json");		
			
		//	json.writeData("inventory.json", inventoryList);
		}
		catch (InventoryErrorException e)
		{
			// throw error to SF if there is an issue
			throw new InventoryErrorException(e.getMessage());
		}
				
	}
	
	/**
	 * Remove item from Saleable quantity
	 * @param quantity Set the quantity of 
	 * @param index selected item
	 * @return New item with updated quantity
	 * @throws DataHandlingException Not enough stock of item for user to make purchase
	 */
	public Saleable removeItem(int index, int quantity) throws DataHandlingException
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
		// if the quantity is less than 0 
		if(inventoryList.get(index).getQuantity() < 0)
		{
			// revert quantity
			inventoryList.get(index).setQuantity(inventoryList.get(index).getQuantity() + quantity);

			// throw an error
			throw new DataHandlingException("Not enough of this item in stock. Please Try Again.");
		}
		// clone item
		Saleable clone = new Saleable(inventoryList.get(index));
		// return cloned item
		return clone;
	}
	
		
	/**
	 * Add item to inventory list
	 * @param index where to add items to quantity
	 * @param quantity Being manipulated at passed in index
	 */
	public void readdItem(int index, int quantity)
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
	 * Add a new item
	 * @param item New item
	 */
	public void addNewItem(Saleable item)
	{
		// add new item
		inventoryList.add(item);
	}
	
	/**
	 * Allows access to full current inventory
	 * @return current inventory list
	 */
	public ArrayList<Saleable> getInventory()
	{
		return inventoryList;
	}
	
	/**
	 * Save inventory at the end of SF main method
	 * @throws DataHandlingException Problem with data type
	 * @throws InventoryErrorException Problem saving inventory
	 */
	public void saveInventory() throws InventoryErrorException, DataHandlingException
	{
		// create file service instance
		JSON json = new JSON();
		// write data once store closes
		try
		{
			// try to save data to json
			json.writeData("inventory.json", inventoryList);
		} 
		catch (InventoryErrorException e) 
		{
			// problem updating inventory
			throw new InventoryErrorException(e.getMessage());
		}
		catch (DataHandlingException e)
		{
			// problem finding
			throw new DataHandlingException(e.getMessage());
		}
	}
	
	

}
