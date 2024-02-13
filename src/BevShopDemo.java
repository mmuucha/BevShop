import java.util.Random;

public class BevShopDemo 
{
    public static void main(String[] args) 
    {
        BevShop bevShop = new BevShop();
        Random random = new Random();

        // Generate random customer details
        String[] customerNames = {"Alice", "Bob", "Charlie", "David", "Emma"};
        String randomCustomerName = customerNames[random.nextInt(customerNames.length)];
        int randomCustomerAge = random.nextInt(50) + 18; // Random age between 18 and 67

        bevShop.startNewOrder(10, Day.MONDAY, randomCustomerName, randomCustomerAge);

        // Process random number of random orders
        int numOrders = random.nextInt(5) + 1; // Generate at least 1 order
        for (int i = 0; i < numOrders; i++) 
        {
            int beverageType = random.nextInt(3); // Randomly choose a beverage type

            Size randomSize = Size.values()[random.nextInt(Size.values().length)];
            String[] beverageNames = {"Espresso", "Latte", "Mocha", "Vodka", "Rum", "Tequila", "Tropical", "Berry"};
            String randomBeverageName = beverageNames[random.nextInt(beverageNames.length)];

            switch (beverageType) 
            {
                case 0:
                    // Process Coffee order
                    bevShop.processCoffeeOrder(randomBeverageName, randomSize, random.nextBoolean(), random.nextBoolean());
                    break;
                case 1:
                    // Process Alcohol order
                    bevShop.processAlcoholOrder(randomBeverageName, randomSize);
                    break;
                case 2:
                    // Process Smoothie order
                    bevShop.processSmoothieOrder(randomBeverageName, randomSize, random.nextInt(5), random.nextBoolean());
                    break;
            }
        }

        // Display order details
        Order currentOrder = bevShop.getCurrentOrder();
        if (currentOrder != null) 
        {
            System.out.println("Order Details:");
            System.out.println(currentOrder.toString());
            System.out.println("Total Order Price: $" + bevShop.totalOrderPrice(currentOrder.getOrderNumber()));
        }

        // Print total monthly sale
        System.out.println("Total Monthly Sale: $" + bevShop.totalMonthlySale());
    }
}