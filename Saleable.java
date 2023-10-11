package finalHollenback;

/**
 * Saleable object that will eventually make up the shopping cart and inventory lists
 */
public class Saleable {
	private String name;
	private String description;
	private float price;
	private int quantity;
	
	/**
	 * Non-Default constructor
	 * @param name Passes in specified name
	 * @param description Passes in specified name
	 * @param price Passes in specified price
	 * @param quantity Passes in specified quantity
	 */
	public Saleable(String name, String description, float price, int quantity)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Gets the name property
	 * @return Current name property
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the description property
	 * @return Current description property
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Gets the price property
	 * @return Current price property
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * Gets the quantity property
	 * @return Current quantity property
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the quantity property
	 * @param quantity
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	@Override
	public String toString() 
	{
		String format = name + " | " + description + " | " +  price + " | " + quantity;
		return format;
	}
	
	
	
}
