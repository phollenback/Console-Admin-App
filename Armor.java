package saleable.type;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Type of saleable that inherits saleable class
 */
//@JsonTypeName("armor")
public class Armor extends Saleable {
	
	
	/**
	 * Inherits Saleable
	 * @param Id Id of salable
	 * @param name OF saleable
	 * @param description of Saleable
	 * @param price Of Saleable
	 * @param quantity of Saleable
	 */
	public Armor(int Id, String name, String description, float price, int quantity)
	{
		super(Id, name, description, price, quantity);
	}
	
	/**
	 * Default Constructor
	 */
	public Armor()
	{
		super();
	}

	

	
	
	
	
}
