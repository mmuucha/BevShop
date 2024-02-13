public class Coffee extends Beverage 
{
    private final double EXTRA_SHOT_COST = 0.5;
    private final double EXTRA_SYRUP_COST = 0.5;
    private boolean extraShot;
    private boolean extraSyrup;

    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
    {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public boolean getExtraShot() 
    {
        return extraShot;
    }

    public boolean getExtraSyrup() 
    {
        return extraSyrup;
    }

    @Override
    public double calcPrice() 
    {
        double price = getBasePrice();

        switch (getSize()) {
            case SMALL:
                price += 0;
                break;
            case MEDIUM:
                price += 1;
                break;
            case LARGE:
                price += 2;
                break;
        }

        if (extraShot) {
            price += EXTRA_SHOT_COST;
        }

        if (extraSyrup) {
            price += EXTRA_SYRUP_COST;
        }

        return price;
    }

    @Override
    public String toString() 
    {
        return super.toString() +
                ", Extra Shot: " + extraShot +
                ", Extra Syrup: " + extraSyrup +
                ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object anotherBev) 
    {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        if (!super.equals(anotherBev)) return false;
        Coffee coffee = (Coffee) anotherBev;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }
}
	
	
	


