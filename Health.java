package finalHollenback;

public class Health extends Saleable{

	private String type;
	
	public String getType()
	{
		return type;
	}
	
	public Health(String name, String description, float price, int quantity)
	{
		super(name, description, price, quantity);
	}

}
