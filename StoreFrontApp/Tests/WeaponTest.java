package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import saleable.type.Weapon;

/**
 * Testing the weapon class
 */
public class WeaponTest {

	/**
	 * Tests non default
	 */
    @Test
    public void testWeaponConstructor() {
        // Arrange
        int id = 1;
        String name = "Test Weapon";
        String description = "This is a test weapon";
        float price = 99.99f;
        int quantity = 10;

        // Create
        Weapon weapon = new Weapon(id, name, description, price, quantity);

        // Check assertions
        assertEquals(id, weapon.getId());
        assertEquals(name, weapon.getName());
        assertEquals(description, weapon.getDescription());
        assertEquals(price, weapon.getPrice(), 0.001); 
        assertEquals(quantity, weapon.getQuantity());
    }

    /**
     * Tests default
     */
    @Test
    public void testWeaponDefaultConstructor() {
        // create
        Weapon weapon = new Weapon();

        // Assert
        assertNotNull(weapon);
    }
}
