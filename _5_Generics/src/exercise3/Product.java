package exercise3;

import java.util.Scanner;

//declare a parameterized interface Higher
interface Higher<T> {
    public boolean isHigher(T t);
}

//update the class header
class Product implements Higher<Product> {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Product(Scanner sc) {
        name = sc.next();
        price = sc.nextInt();
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean isHigher(Product product) {
        return name.compareTo(product.name) < 0;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }

}

//update the class header
class Purchase implements Higher<Purchase> {
    private final Product product;
    private final int number;

    public Purchase(Product product, int number) {
        super();
        this.product = product;
        this.number = number;
    }

    public Purchase(Scanner sc) {
        product = new Product(sc);
        number = sc.nextInt();
    }

    public int getCost() {
        return product.getPrice() * number;
    }

    @Override
    public boolean isHigher(Purchase purchase) {
        return getCost() > purchase.getCost();
    }

    @Override
    public String toString() {
        return "Purchase [product=" + product + ", number=" + number + ", getCost()=" + getCost() + "]";
    }

}

class Solution {
    //declare a static method getHighest
    //that accepts an array of objects of the type parameter T
    //and returns the highest element of the array.
    public static <T extends Higher<T>> T getHighest(T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }

        T highest = array[0];
        for (T t : array) {
            if (t.isHigher(highest)) {
                highest = t;
            }
        }
        return highest;
    }
}