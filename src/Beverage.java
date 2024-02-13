
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, 
		FRIDAY, SATURDAY, SUNDAY }

enum Size { SMALL, MEDIUM, LARGE}

enum Type { COFFEE, SMOOTHIE, ALCOHOL }


public abstract class Beverage 
{
	private String bevName; 
	private Type bevType; 
	private Size bevSize;
	
	private double price; 
	private final double basePrice = 2.0; 
	private final double sizePrice = 1; 

	
	public Beverage(String bevName, Type type, Size size)
	{
		this.bevName = bevName; 
		bevType = type; 
		bevSize = size; 
	}
	
	
	public double getBasePrice()
	{
		return basePrice; 
	}
	
	public Type getType()
	{
		return bevType;
	}
	
	public String getBevName()
	{
		return bevName; 
	}
	
	
	public Size getSize()
	{
		return bevSize; 
	}
	
	public double addSizePrice()
	{
		return sizePrice; 
	}
	

	public String toString()
	{
		return "Beverage name: " + bevName + 
				"\nBeverage size: " + bevSize; 
	}
	

	public boolean equals(Beverage anotherBev)
	{
		if(bevName.equals(anotherBev.getBevName()) && bevType.equals(anotherBev.getType()) && bevSize.equals(anotherBev.getSize()))
		{
			return true; 
		}
		
		else
		{
			return false; 
		}
		
	}
	
	public abstract double calcPrice();
	
	 
	
	public void setName(String name)
	{
		bevName = name; 
	}
	
	public void setType(Type type)
	{
		bevType = type; 
	}
	
	public void setSize(Size size)
	{
		bevSize = size; 
	}
	
	
}
