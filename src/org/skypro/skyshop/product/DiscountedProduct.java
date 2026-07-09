package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int price;
    private int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        double priceOfDiscount = price * (discount/100.0);
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
