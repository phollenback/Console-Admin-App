package finalHollenback;

/**
 * Type of saleable that inherits saleable class
 */
public class Health extends Saleable{
	
	
	/**
	 * Inherits Saleable
	 * @param name of saleable
	 * @param description of saleable
	 * @param price of saleable
	 * @param quantity of saleable
	 */
	public Health(int Id, String name, String description, float price, int quantity)
	{
		super(Id, name, description, price, quantity);
	}

}
