package finalHollenback;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Type of Saleable that inherits saleable class
 */
//@JsonTypeName("weapon")
public class Weapon extends Saleable {	

	/**
	 * Constructor of Weapon
	 * @param Id Id of salable
	 * @param name of Saleable
	 * @param description Of Saleable
	 * @param price Of Saleable
	 * @param quantity Of Saleable
	 */
	public Weapon(int Id, String name, String description, float price, int quantity) 
	{
		super(Id, name, description, price, quantity);
	}

}
