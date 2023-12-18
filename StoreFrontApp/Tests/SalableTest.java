package test;

import org.junit.jupiter.api.Test;

import saleable.type.Saleable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test all methods in the salable base class
 */
class SaleableTest {

	/**
	 * See if default constructor works as intended
	 */
    @Test
    void testDefaultConstructor() {
        Saleable saleable = new Saleable();
        assertEquals(0, saleable.getId());
        assertEquals("", saleable.getName());
        assertEquals("", saleable.getDescription());
        assertEquals(0.0f, saleable.getPrice());
        assertEquals(0, saleable.getQuantity());
    }

    /**
     * See if non default constructor works properly
     */
    @Test
    void testNonDefaultConstructor() {
        Saleable saleable = new Saleable(1, "item", "desc", 10.12f, 5);
        assertEquals(1, saleable.getId());
        assertEquals("item", saleable.getName());
        assertEquals("desc", saleable.getDescription());
        assertEquals(10.12f, saleable.getPrice(), 0.001);
        assertEquals(5, saleable.getQuantity());
    }

    /**
     * Test to see if copy constructor works as intended
     */
    @Test
    void testCopyConstructor() {
        Saleable first = new Saleable(1, "Item1", "Description1", 10.99f, 5);
        Saleable copy = new Saleable(first);
        assertEquals(first.getId(), copy.getId());
        assertEquals(first.getName(), copy.getName());
        assertEquals(first.getDescription(), copy.getDescription());
        assertEquals(first.getPrice(), copy.getPrice(), 0.001);
        assertEquals(first.getQuantity(), copy.getQuantity());
    }

    /**
     * Test to string
     */
    @Test
    void testToString() {
        Saleable saleable = new Saleable(1, "Item1", "Description1", 10.99f, 5);
        String expectedString = "1. Item1 | Description1 | 10.99 | 5";
        assertEquals(expectedString, saleable.toString());
    }
    
    /**
     * Test Getters and setters
     */
    @Test
    public void testGettersAndSetters() {
        // Arrange
        int id = 1;
        String name = "Test Item";
        String description = "This is a test item";
        float price = 29.99f;
        int quantity = 7;

        // Create a Saleable object
        Saleable saleable = new Saleable();

        // Set values using setters
        saleable.setId(id);
        saleable.setName(name);
        saleable.setDescription(description);
        saleable.setPrice(price);
        saleable.setQuantity(quantity);

        // Check assertions using getters
        assertEquals(id, saleable.getId());
        assertEquals(name, saleable.getName());
        assertEquals(description, saleable.getDescription());
        assertEquals(price, saleable.getPrice(), 0.001);
        assertEquals(quantity, saleable.getQuantity());
    }

    /**
     * See if compare to works as intended
     */
    @Test
    void testCompareTo() {
    	// create instances
        Saleable saleable1 = new Saleable(1, "Item1", "Description1", 10.99f, 5);
        Saleable saleable2 = new Saleable(2, "Item2", "Description2", 5.99f, 10);
        Saleable saleable3 = new Saleable(3, "Item3", "Description3", 15.99f, 3);
        // check if they are in correct order
        assertTrue(saleable1.compareTo(saleable2) < 0);
        assertTrue(saleable2.compareTo(saleable3) < 0);
        assertTrue(saleable1.compareTo(saleable3) < 0);
        // check if its in the right order
        assertTrue(saleable2.compareTo(saleable1) > 0);
        assertTrue(saleable3.compareTo(saleable2) > 0);
        assertTrue(saleable3.compareTo(saleable1) > 0);
        // 
        assertEquals(0, saleable1.compareTo(new Saleable(1, "Item1", "Description1", 10.99f, 5)));
    }
}
