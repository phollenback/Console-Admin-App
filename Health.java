package saleable.type;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Type of saleable that inherits saleable class
 */
//@JsonTypeName("health")
public class Health extends Saleable{
	
	
	/**
	 * Inherits Saleable
	 * @param Id Id of salable
	 * @param name of saleable
	 * @param description of saleable
	 * @param price of saleable
	 * @param quantity of saleable
	 */
	public Health(int Id, String name, String description, float price, int quantity)
	{
		super(Id, name, description, price, quantity);
	}
	
	/**
	 * Default constructor
	 */
	public Health()
	{
		super();
	}

}
