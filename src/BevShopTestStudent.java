import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BevShopTestStudent {

    private BevShop bevShop;

    @BeforeEach
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(8));
        assertTrue(bevShop.isValidTime(12));
        assertFalse(bevShop.isValidTime(6));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        assertEquals(BevShopInterface.MIN_AGE_FOR_ALCOHOL, bevShop.getMaxNumOfFruits());
    }

    // Add more tests for other methods...

    @Test
    public void testSortOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.startNewOrder(12, Day.TUESDAY, "Alice", 30);
        bevShop.startNewOrder(9, Day.WEDNESDAY, "Bob", 20);

        bevShop.sortOrders();

        Order firstOrder = bevShop.getOrderAtIndex(0);
        Order secondOrder = bevShop.getOrderAtIndex(1);
        Order thirdOrder = bevShop.getOrderAtIndex(2);

        assertEquals("Bob", firstOrder.getCustomer().getName());
        assertEquals("John", secondOrder.getCustomer().getName());
        assertEquals("Alice", thirdOrder.getCustomer().getName());
    }

    // Add more tests for other scenarios...

}