package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int price;
    private int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.discount = discount;
        this.price = price;
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Размер скидки должен быть от 0% до 100%");
        }
    }

    @Override
    public int getPrice() {
        double priceOfDiscount = price * (discount / 100.0);
        return (int) (price - priceOfDiscount);


    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPrice() + " (" + discount + "%)";
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
