import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTestStudent {

    @Test
    public void testOrderInitialization() {
        Customer customer = new Customer("John", 25);
        Order order = new Order(10, Day.MONDAY, customer);

        assertEquals(10, order.getOrderTime());
        assertEquals(Day.MONDAY, order.getOrderDay());
        assertEquals(customer.getName(), order.getCustomer().getName());
        assertEquals(customer.getAge(), order.getCustomer().getAge());
        assertNotNull(order.getBeverages());
        assertTrue(order.getBeverages().isEmpty());
    }

    @Test
    public void testAddingBeverages() {
        Order order = new Order(15, Day.FRIDAY, new Customer("Alice", 30));
        order.addNewBeverage("Latte", Size.SMALL, true, false);
        order.addNewBeverage("IPA Beer", Size.MEDIUM);
        order.addNewBeverage("Tropical Smoothie", Size.LARGE, 3, true);

        List<String> expectedBevNames = Arrays.asList("Latte", "IPA Beer", "Tropical Smoothie");
        assertEquals(3, order.getTotalItems());
        for (int i = 0; i < expectedBevNames.size(); i++) {
            assertEquals(expectedBevNames.get(i), order.getBeverage(i).getBevName());
        }
    }

    @Test
    public void testCalcOrderTotal() {
        Order order = new Order(12, Day.WEDNESDAY, new Customer("Bob", 22));
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        order.addNewBeverage("Margarita", Size.LARGE);
        order.addNewBeverage("Berry Blast", Size.MEDIUM, 2, true);

        double expectedTotal = 2.0 + 4.0 + 4.5; // Prices of beverages added above
        assertEquals(expectedTotal, order.calcOrderTotal());
    }

    @Test
    public void testFindNumOfBeveType() {
        Order order = new Order(18, Day.SATURDAY, new Customer("Eve", 28));
        order.addNewBeverage("Cappuccino", Size.LARGE);
        order.addNewBeverage("IPA Beer", Size.SMALL);
        order.addNewBeverage("Berry Blast", Size.MEDIUM, 1, true);

        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(2, order.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(0, order.findNumOfBeveType(Type.SMOOTHIE));
    }

    @Test
    public void testOrderToString() {
        Order order = new Order(14, Day.THURSDAY, new Customer("Grace", 35));
        order.addNewBeverage("Americano", Size.MEDIUM);
        order.addNewBeverage("Chardonnay", Size.LARGE);
        order.addNewBeverage("Tropical Smoothie", Size.SMALL, 3, false);

        String expected = "Order Number: " + order.getOrderNumber() +
                ", Time: 14, Day: THURSDAY, Customer: Grace, Customer Age: 35, Beverages: [Beverage name: Americano, Beverage size: MEDIUM, Beverage name: Chardonnay, Beverage size: LARGE, Beverage name: Tropical Smoothie, Beverage size: SMALL, Number of Fruits: 3, Protein Added: false]";
        assertEquals(expected, order.toString());
    }

    // Add more test cases to thoroughly cover different scenarios...

}