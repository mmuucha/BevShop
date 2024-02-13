import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmoothieTestStudent {

    @Test
    public void testSmoothieInitialization() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.SMALL, 3, true);

        assertEquals("Berry Blast", smoothie.getBevName());
        assertEquals(Size.SMALL, smoothie.getSize());
        assertEquals(3, smoothie.getNumOfFruits());
        assertTrue(smoothie.getAddProtein());
    }

    @Test
    public void testCalcPriceWithSmallSize() {
        Smoothie smoothie = new Smoothie("Citrus Punch", Size.SMALL, 2, false);

        assertEquals(3.0, smoothie.calcPrice());
    }

    @Test
    public void testCalcPriceWithMediumSizeAndProtein() {
        Smoothie smoothie = new Smoothie("Tropical Delight", Size.MEDIUM, 4, true);

        assertEquals(7.0, smoothie.calcPrice());
    }

    @Test
    public void testCalcPriceWithLargeSizeAndFruitsAndProtein() {
        Smoothie smoothie = new Smoothie("Mango Madness", Size.LARGE, 5, true);

        assertEquals(11.5, smoothie.calcPrice());
    }

    @Test
    public void testToStringMethod() {
        Smoothie smoothie = new Smoothie("Green Machine", Size.MEDIUM, 3, false);

        assertEquals("Beverage name: Green Machine, Beverage size: MEDIUM, Protein Added: false, Number of Fruits: 3, Price: 5.5", smoothie.toString());
    }

    @Test
    public void testEqualsMethod() {
        Smoothie smoothie1 = new Smoothie("Berry Blast", Size.SMALL, 2, true);
        Smoothie smoothie2 = new Smoothie("Berry Blast", Size.SMALL, 2, true);
        Smoothie smoothie3 = new Smoothie("Tropical Delight", Size.MEDIUM, 4, true);

        assertTrue(smoothie1.equals(smoothie2));
        assertFalse(smoothie1.equals(smoothie3));
    }

    // Add more tests for other scenarios...

}