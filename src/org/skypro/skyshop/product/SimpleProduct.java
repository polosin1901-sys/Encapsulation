package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
        if (getPrice() <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0");
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPrice();
    }

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }


}
