public class Alcohol extends Beverage 
{
    private boolean isWeekend;
    private final double WEEKEND_COST = 0.60;

    public Alcohol(String bevName, Size size, boolean isWeekend) 
    {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
        
    }

    

	public boolean isWeekend() 
	{
        return isWeekend;
    }

    @Override
    public double calcPrice() 
    {
        double price = getBasePrice(); // Get the base price from Beverage class

        // Additional cost for weekend drinks
        if (isWeekend) {
            price += WEEKEND_COST;
        }

        return price;
    }

    @Override
    public String toString() 
    {
        return "Alcohol: Name: " + getBevName() +
                ", Size: " + getSize() +
                ", Offered in Weekend: " + isWeekend +
                ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object anotherBev) 
    {
        if (this == anotherBev) {
            return true;
        }
        if (anotherBev == null || getClass() != anotherBev.getClass()) {
            return false;
        }
        if (!super.equals(anotherBev)) {
            return false;
        }
        Alcohol otherAlcohol = (Alcohol) anotherBev;
        return isWeekend == otherAlcohol.isWeekend;
    }
}