package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import saleable.type.Armor;

/**
 * Testing the armor class
 */
public class ArmorTest {

	/**
	 * Tests non default
	 */
    @Test
    public void testArmorConstructor() {
        // Arrange
        int id = 1;
        String name = "Test Armor";
        String description = "This is a test armor";
        float price = 49.99f;
        int quantity = 3;

        // Create and insert
        Armor armor = new Armor(id, name, description, price, quantity);

        // Check assertions
        assertEquals(id, armor.getId());
        assertEquals(name, armor.getName());
        assertEquals(description, armor.getDescription());
        assertEquals(price, armor.getPrice(), 0.001);
        assertEquals(quantity, armor.getQuantity());
    }

    /**
     * Tests default
     */
    @Test
    public void testArmorDefaultConstructor() {
        // Create
        Armor armor = new Armor();

        // check if null assertion
        assertNotNull(armor);
    }
}
