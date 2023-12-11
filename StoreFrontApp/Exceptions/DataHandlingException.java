package Exceptions;

/**
 * Problem converting data around
 */
public class DataHandlingException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Non-Default Constructor
	 * @param errorMessage What to return to SF
	 */
	public DataHandlingException(String errorMessage)
	{
		super(errorMessage);
	}
	
	

}
