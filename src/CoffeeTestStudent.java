import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeTestStudent {

    @Test
    public void testCalcPriceWithoutExtras() {
        Beverage coffeeSmall = new Coffee("Espresso", Size.SMALL, false, false);
        Beverage coffeeMedium = new Coffee("Latte", Size.MEDIUM, false, false);
        Beverage coffeeLarge = new Coffee("Cappuccino", Size.LARGE, false, false);

        assertEquals(2.0, coffeeSmall.calcPrice());
        assertEquals(3.0, coffeeMedium.calcPrice());
        assertEquals(4.0, coffeeLarge.calcPrice());
    }

    @Test
    public void testCalcPriceWithExtras() {
        Beverage coffeeWithExtraShot = new Coffee("Espresso", Size.SMALL, true, false);
        Beverage coffeeWithExtraSyrup = new Coffee("Latte", Size.MEDIUM, false, true);
        Beverage coffeeWithBothExtras = new Coffee("Cappuccino", Size.LARGE, true, true);

        assertEquals(2.5, coffeeWithExtraShot.calcPrice());
        assertEquals(3.5, coffeeWithExtraSyrup.calcPrice());
        assertEquals(5.0, coffeeWithBothExtras.calcPrice());
    }

    @Test
    public void testEqualsMethod() {
        Beverage coffee1 = new Coffee("Espresso", Size.SMALL, true, false);
        Beverage coffee2 = new Coffee("Espresso", Size.SMALL, true, false);
        Beverage coffee3 = new Coffee("Latte", Size.MEDIUM, false, true);

        assertTrue(coffee1.equals(coffee2));
        assertFalse(coffee1.equals(coffee3));
    }

    // Add more tests for other scenarios...

}