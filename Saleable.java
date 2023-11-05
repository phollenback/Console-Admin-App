package finalHollenback;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Saleable object that will eventually make up the shopping cart and inventory lists
 */
//@JsonTypeInfo(
//	    use = JsonTypeInfo.Id.NAME,
//	    include = JsonTypeInfo.As.PROPERTY,
//	    property = "@type"
//	)
//	@JsonSubTypes({
//	    @JsonSubTypes.Type(value = Armor.class, name = "armor"),
//	    @JsonSubTypes.Type(value = Health.class, name = "health"),
//	    @JsonSubTypes.Type(value = Weapon.class, name = "weapon")
//	})
public class Saleable implements Comparable<Saleable>
{
	private int Id;
	private String name;
	private String description;
	private float price;
	private int quantity;
	
	/**
	 * Non-Default constructor
	 * @param Id Unique identifier of item
	 * @param name Passes in specified name
	 * @param description Passes in specified name
	 * @param price Passes in specified price
	 * @param quantity Passes in specified quantity
	 */
	public Saleable(int Id, String name, String description, float price, int quantity)
	{
		this.Id = Id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Default Constructor
	 */
	public Saleable()
	{
		this.Id = 0;
		this.name = "";
		this.description = "";
		this.price = 0;
		this.quantity = 0;
		
	}
	
	/**
	 * Copy Constructor
	 * @param other Create a saleable that matches other in different memory address
	 */
	public Saleable(Saleable other)
	{
		this.Id = other.Id;
		this.name = other.name;
		this.description = other.description;
		this.price = other.price;
		this.quantity = other.quantity;
		
	}
	
	/**
	 * Gets the Id property
	 * @return Saleable current Id
	 */
	public int getId()
	{
		return Id;
	}
	
	/**
	 * Set Id 
	 * @param Id Passed in correct id
	 */
	public void setId(int Id)
	{
		this.Id = Id;
	}
	
	/**
	 * Gets the name property
	 * @return Current name property
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets name property
	 * @param name Set to this name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the description property
	 * @return Current description property
	 */
	public String getDescription() 
	{
		return description;
	}
	
	/**
	 * Sets description for object
	 * @param desc Passes in new description
	 */
	public void setDescription(String desc)
	{
		this.description = desc;
	}
	
	/**
	 * Gets the price property
	 * @return Current price property
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * Sets new price property
	 * @param price New price variable
	 */
	public void setPrice(float price)
	{
		this.price = price;
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
	 * @param quantity Quantity of current item
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * Overrides toString to out print correctly formatted item
	 */
	@Override
	public String toString() 
	{
		return  Id + ". " + name + " | " + description + " | " +  price + " | " + quantity;
	}
	/**
	 * Compares Item names against eachother in order to sort
	 */
	@Override
	public int compareTo(Saleable other)
	{
		// gathers number of which name has a number earlier in the alphabet
		int comp = this.name.compareTo(other.name);
		// if compare int is less than 1 
		if(comp < 0) return -1;
		// if compare int is more than 1
		if(comp > 0) return 1;
		// return even
		return 0;
	}
	
	
	
	
}
