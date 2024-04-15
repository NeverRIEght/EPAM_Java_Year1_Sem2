package section2.exercise3;


class Product {
    //declare instance constants name and price
    private final String name;
    private final int price;

    //declare a parameterized constructor
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //declare getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    //declare toString
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [name=" + name + ", price=" + price + "]";
    }
}

class Purchase {
    //declare instance constants product and number
    private final Product product;
    private final int number;

    //declare a parameterized constructor
    public Purchase(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    //declare getters
    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    //do not change signatures of methods
    protected int getFinalCost(int baseCost) {
        return baseCost;
    }

    public final int getCost() {
        //replace 0 by a product of price by number
        int baseCost = product.getPrice() * number;
        return getFinalCost(baseCost);
    }

    protected String fieldsToString() {
        //replace returned expression by Java code in the given format
        //return product and number
        return " [product=" + product +
                ", number=" + number;
    }

    @Override
    public final String toString() {
        //replace returned expression by Java code in the given format
        //return class_name_part + fieldsToString() + getCost_part
        return this.getClass().getSimpleName() + fieldsToString() + ", getCost()=" + getCost() + "]";
    }

}

class TransportExpencesPurchase extends Purchase {
    //declare instance constant expences
    private final int expences;

    //declare a parameterized constructor
    public TransportExpencesPurchase(Product product, int number, int expences) {
        super(product, number);
        this.expences = expences;
    }

    //do not change signatures of methods
    @Override
    protected int getFinalCost(int baseCost) {
        //put your code here
        return baseCost + expences;
    }

    @Override
    protected String fieldsToString() {
        //put your code here
        return super.fieldsToString() +
                ", expences=" + expences;
    }
}

class PriceDiscountPurchase extends Purchase {
    //declare instance constant discount
    private final int discount;

    //declare a parameterized constructor
    public PriceDiscountPurchase(Product product, int number, int discount) {
        super(product, number);
        this.discount = discount;
    }

    //do not change signatures of methods
    @Override
    protected int getFinalCost(int baseCost) {
        //put your code here
        return baseCost - discount * getNumber();
    }

    @Override
    protected String fieldsToString() {
        //put your code here
        return super.fieldsToString() +
                ", discount=" + discount;
    }
}

class WholesalePurchase extends Purchase {
    //declare instance constant percent and class constant LIMIT
    private final double percent;
    private static final int LIMIT = 20;

    //declare a parameterized constructor
    public WholesalePurchase(Product product, int number, double percent) {
        super(product, number);
        this.percent = percent;
    }

    //do not change signatures of methods
    @Override
    protected int getFinalCost(int baseCost) {
        //put your code here
        if (getNumber() >= 20) {
            return (int) Math.round(baseCost * (1 - percent / 100));
        }
        return baseCost;
    }

    @Override
    protected String fieldsToString() {
        //put your code here
        return super.fieldsToString() +
                ", percent=" + percent;
    }
}



