package finalHollenback;

public class Weapon extends Saleable {
	
	private String ammoType;
	

	public String getAmmoType() 
	{
		return ammoType;
	}


	public Weapon(String name, String description, float price, int quantity) 
	{
		super(name, description, price, quantity);
	}

}
