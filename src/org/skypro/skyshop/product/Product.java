package org.skypro.skyshop.product;

import org.skypro.skyshop.Interface.Searchable;

import java.util.LinkedList;
import java.util.Objects;

public abstract class Product extends LinkedList<Product> implements Searchable {

    private final String name;


    public Product(String productName) {
        this.name = productName;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не должно быть null или пустой строкой");
        }
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
