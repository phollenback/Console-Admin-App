package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import saleable.type.Health;

/**
 * Testing the health class
 */
public class HealthTest {

	/**
	 * Tests non default
	 */
    @Test
    public void testHealthConstructor() {
        // Arrange
        int id = 1;
        String name = "Test Health";
        String description = "This is a test health item";
        float price = 19.99f;
        int quantity = 5;

        // Create instance and insert
        Health health = new Health(id, name, description, price, quantity);

        // Check assertions
        assertEquals(id, health.getId());
        assertEquals(name, health.getName());
        assertEquals(description, health.getDescription());
        assertEquals(price, health.getPrice(), 0.001);
        assertEquals(quantity, health.getQuantity());
    }

    /**
     * Tests default
     */
    @Test
    public void testHealthDefaultConstructor() {
        // Create
        Health health = new Health();

        // check if is null
        assertNotNull(health);
    }
}
