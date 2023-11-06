package finalHollenback;

import java.util.ArrayList;

import Exceptions.DataHandlingException;
import Exceptions.InventoryErrorException;
/**
 * Interface for whichever form of data input there is
 */
public interface FileService 
{
	/**
	 * Reads data from data source
	 * @param name Where data is coming from
	 * @return Inventory list
	 * @throws InventoryErrorException Problem reading inventory
	 */
	public ArrayList<Saleable> readData (String name) throws InventoryErrorException;
	
	/**
	 * Write data back to specified data source
	 * @param name Where the data is getting written to
	 * @param inventory What to write to data source
	 * @throws DataHandlingException Problem putting data into source
	 * @throws InventoryErrorException Error with inventory
	 */
	public void writeData (String name, ArrayList<Saleable> inventory) throws DataHandlingException, InventoryErrorException;
	
}
