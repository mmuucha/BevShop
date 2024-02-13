public class Smoothie extends Beverage {
    private final double PROTEIN_COST = 1.5;
    private final double FRUIT_COST = 0.5;

    private int numOfFruits;
    private boolean addProtein;

    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    public boolean getAddProtein() {
        return addProtein;
    }

    @Override
    public double calcPrice() {
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

        if (addProtein) {
            price += PROTEIN_COST;
        }

        price += numOfFruits * FRUIT_COST;

        return price;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Protein Added: " + addProtein +
                ", Number of Fruits: " + numOfFruits +
                ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        if (!super.equals(anotherBev)) return false;
        Smoothie smoothie = (Smoothie) anotherBev;
        return numOfFruits == smoothie.numOfFruits && addProtein == smoothie.addProtein;
    }
}