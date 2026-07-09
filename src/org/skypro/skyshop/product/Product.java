package org.skypro.skyshop.product;

import org.skypro.skyshop.Interface.Searchable;

public abstract class Product implements Searchable {

    private final String name;


    public Product(String productName) {
        this.name = productName;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();


}
