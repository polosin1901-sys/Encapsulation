package org.skypro.skyshop.product;

public class Product {

    private final String name;
    private final int price;

    public Product(String productName, int costOfTheProduct) {
        this.name = productName;
        this.price = costOfTheProduct;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
