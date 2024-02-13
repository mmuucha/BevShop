import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTestStudent {

    @Test
    public void testCustomerInitialization() {
        Customer customer = new Customer("John", 30);

        assertEquals("John", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testSetName() {
        Customer customer = new Customer("Alice", 25);
        customer.setName("Bob");

        assertEquals("Bob", customer.getName());
    }

    @Test
    public void testSetAge() {
        Customer customer = new Customer("Eve", 35);
        customer.setAge(40);

        assertEquals(40, customer.getAge());
    }

    @Test
    public void testCustomerCopyConstructor() {
        Customer originalCustomer = new Customer("Michael", 28);
        Customer copiedCustomer = new Customer(originalCustomer);

        assertEquals(originalCustomer.getName(), copiedCustomer.getName());
        assertEquals(originalCustomer.getAge(), copiedCustomer.getAge());
    }

    @Test
    public void testToStringMethod() {
        Customer customer = new Customer("Sarah", 22);

        assertEquals("Sarah22", customer.toString());
    }

    // Add more tests for other scenarios...

}