package finalHollenback;
/**
 * Type of Saleable that inherits saleable class
 */
public class Weapon extends Saleable {	

	/**
	 * Constructor of Weapon
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
