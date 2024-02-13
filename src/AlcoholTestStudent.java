import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AlcoholTestStudent {

    @Test
    void testCalcPriceForWeekend() {
        // Test for weekend alcohol drink
        Beverage alcoholWeekend = new Alcohol("Vodka", Size.MEDIUM, true);
        assertEquals(2.60, alcoholWeekend.calcPrice()); // Assuming the base price is 2.0 and weekend cost is 0.60
    }

    @Test
    void testCalcPriceForWeekday() {
        // Test for weekday alcohol drink
        Beverage alcoholWeekday = new Alcohol("Rum", Size.SMALL, false);
        assertEquals(2.0, alcoholWeekday.calcPrice()); // Assuming the base price is 2.0
    }

    @Test
    void testEquals() {
        Beverage alcohol1 = new Alcohol("Gin", Size.LARGE, true);
        Beverage alcohol2 = new Alcohol("Gin", Size.LARGE, true);
        assertEquals(alcohol1, alcohol2);
    }


}