import java.util.ArrayList;
import java.util.List; 
import java.util.Random; 

public class Order implements OrderInterface, Comparable<Order>
{
	private int orderNumber; 
	private int orderTime;
	private Day orderDay; 
	private Customer customer;
	private List<Beverage> beverages; 
	
	
	public List<Beverage> getBeverages() 
	{
        return beverages;
    }
	
	
	public Order(int orderTime, Day orderDay, Customer cust) 
	{
	    this.orderTime = orderTime;
	    this.orderDay = orderDay;
	    this.customer = new Customer(cust.getName(), cust.getAge());
	    this.beverages = new ArrayList<>();
	    this.orderNumber = generateOrder(); // Set the order number when creating the order
	}
	
	public int generateOrder()
	{
		return new Random().nextInt(80001)+ 10000;
	}
	
	public int getOrderNumber()
	{
		return orderNumber;
	}
	
	public int getOrderTime()
	{
		return orderTime;
	}
	
	public Day getOrderDay()
	{
		return orderDay;
	}
	
	public Customer getCustomer()
	{
		return new Customer(customer.getName(),customer.getAge());
	}
	
	public Day getDay()
	{
		return orderDay;
	}
	
	@Override
	public boolean isWeekend() 
	{
		return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
	}

	@Override
	public Beverage getBeverage(int itemNo)
	{
		if(itemNo >= 0 && itemNo  <beverages.size())
		{
			return beverages.get(itemNo);
		}
		
		return null; 
	}
	
	public int getTotalItems()
	{
		return beverages.size(); 
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
	{
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(coffee);
	}

	@Override
	public void addNewBeverage(String bevName, Size size) 
	{
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
		beverages.add(alcohol);

	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(smoothie);

	}

	@Override
	public double calcOrderTotal() 
	{
		double total = 0.0; 
		for (Beverage beverage : beverages)
		{
			total += beverage.calcPrice();
		}
		
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) 
	{
		int count = 0;
		
		for(Beverage beverage : beverages)
		{
			if(beverage.getType() == type)
			{
				count++; 
			}
		}
		return count; 
	}
	
	@Override
    public String toString() 
	{
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order Number: ").append(orderNumber)
                .append(", Time: ").append(orderTime)
                .append(", Day: ").append(orderDay)
                .append(", Customer: ").append(customer.getName())
                .append(", Customer Age: ").append(customer.getAge())
                .append(", Beverages: ").append(beverages);
        return orderDetails.toString();
    }

    @Override
    public int compareTo(Order anotherOrder) 
    {
        return Integer.compare(this.orderNumber, anotherOrder.orderNumber);
    }
	

}
