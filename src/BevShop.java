
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BevShop implements BevShopInterface 
{
	
	private int numOfAlcoholDrinks;
    public ArrayList<Order> orders; 
    
    

    public BevShop() 
    {
        orders = new ArrayList<>();

    }


    @Override
    public boolean isValidTime(int time) 
    {
        return (time >= 8 && time <= 23);
    }

    
    @Override
    public int getMaxNumOfFruits() 
    {
        // Assuming the value representing the minimum age for offering Alcohol drink is 21
        return MIN_AGE_FOR_ALCOHOL;
    }

  

    @Override
    public int getMinAgeForAlcohol() 
    {
        // Assuming the value representing the maximum age for offering Alcohol drink is 21
        return MIN_AGE_FOR_ALCOHOL;
    }



    @Override
    public boolean isMaxFruit(int numOfFruits) 
    {
        // Assuming the maximum number of fruits allowed for SMOOTHIE is defined as MAX_FRUIT
        return numOfFruits > MAX_FRUIT;
    }



    @Override
    public int getMaxOrderForAlcohol() 
    {
        return MAX_ORDER_FOR_ALCOHOL;
    }


    @Override
    public boolean isEligibleForMore() 
    {
        return numOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }


	@Override
	public int getNumOfAlcoholDrink() 
	{
        return numOfAlcoholDrinks;

	}


	@Override
	public boolean isValidAge(int age) 
	{
        return age >= MIN_AGE_FOR_ALCOHOL;
	}


	@Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) 
	{
        Customer customer = new Customer(customerName, customerAge);
        Order newOrder = new Order(time, day, customer);
        orders.add(newOrder);
    }


	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
	{
	    Beverage coffee = new Coffee(bevName, size, extraShot, extraSyrup);
	    int lastIndex = orders.size() - 1;

	    if (lastIndex >= 0) {
	        orders.get(lastIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
	    } else {
	        // Handle scenario when there is no existing order
	        System.out.println("No existing order to add the coffee beverage.");
	        // Or you can create a new order here
	        // Example: startNewOrder(time, day, customerName, customerAge);
	    }
	}


	@Override
    public void processAlcoholOrder(String bevName, Size size) 
	{
        int lastIndex = orders.size() - 1;

        if (lastIndex >= 0) 
        {
            orders.get(lastIndex).addNewBeverage(bevName, size);
        } else 
        {
            // Handle scenario when there is no existing order
            System.out.println("No existing order to add the alcohol beverage.");
            // Or you can create a new order here
            // Example: startNewOrder(time, day, customerName, customerAge);
        }
    }

	@Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
        int lastIndex = orders.size() - 1;

        if (lastIndex >= 0) 
        {
            orders.get(lastIndex).addNewBeverage(bevName, size, numOfFruits, addProtein);
        } else 
        {
            // Handle scenario when there is no existing order
            System.out.println("No existing order to add the smoothie beverage.");
            // Or you can create a new order here
            // Example: startNewOrder(time, day, customerName, customerAge);
        }
    }


	 @Override
	    public int findOrder(int orderNo) 
	 {
	        for (int i = 0; i < orders.size(); i++) 
	        {
	            if (orders.get(i).getOrderNumber() == orderNo) 
	            {
	                return i; // Return the index of the found order
	            }
	        }
	        return -1; // Return -1 if order number not found
	    }


	  @Override
	    public double totalOrderPrice(int orderNo) {
	        int index = findOrder(orderNo);

	        if (index != -1) {
	            Order order = orders.get(index);
	            return order.calcOrderTotal();
	        }

	        return 0.0; // Return 0.0 if the order is not found
	    }


	  @Override
	    public double totalMonthlySale() {
	        double totalSale = 0.0;

	        for (Order order : orders) {
	            totalSale += order.calcOrderTotal();
	        }

	        return totalSale;
	    }

	  @Override
	    public int totalNumOfMonthlyOrders() {
	        // Assuming orders are made within a month
	        return orders.size();
	    }


	  @Override
	    public Order getCurrentOrder() {
	        // Assuming the "current" order is the last order in the list
	        if (!orders.isEmpty()) 
	        {
	            int lastIndex = orders.size() - 1;
	            return orders.get(lastIndex);
	        }
	        return null; // Return null if there are no orders
	    }


	  @Override
	    public Order getOrderAtIndex(int index) {
	        if (index >= 0 && index < orders.size()) {
	            return orders.get(index);
	        }
	        return null; // Return null for an invalid index or if the order doesn't exist at that index
	    }


	  public void sortOrders() 
	  {
	        // Sorting orders using Selection Sort algorithm
	        int n = orders.size();

	        for (int i = 0; i < n - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
	                    minIndex = j;
	                }
	            }
	            Collections.swap(orders, minIndex, i);
	        }
	  }
	
	  @Override
	    public String toString() {
	        StringBuilder builder = new StringBuilder();
	        builder.append("Orders:\n");

	        for (Order order : orders) {
	            builder.append(order.toString()).append("\n");
	        }

	        builder.append("Total Monthly Sale: $").append(totalMonthlySale());

	        return builder.toString();
	    }


   
}