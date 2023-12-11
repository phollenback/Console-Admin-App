package Exceptions;

/**
 * Problem moving inventory to/from database
 */
public class InventoryErrorException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Non-Defualt Constructor
	 * @param errorMessage What to return to SF
	 */ 
	public InventoryErrorException(String errorMessage)
	{
		super(errorMessage);
	}

}
