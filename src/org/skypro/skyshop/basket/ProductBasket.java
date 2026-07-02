package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product basket[] = new Product[5];

    public void addProduct(Product product) {
        boolean added = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                added = true;
                break;
            }
        }
        if (!added) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int sumUpThePrice() {
        int sum = 0;
        for (Product p : basket) {
            if (p != null) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        boolean isEmpty = true;
        for (Product p : basket) {
            if (p != null) {
                isEmpty = false;
                System.out.println(p.getName() + " : " + p.getPrice());

            }
        }
        if (isEmpty) {
            System.out.println("В корзине ничего нет");
        } else {
            System.out.println("Итого: " + sumUpThePrice());
        }
    }

    public boolean checkProductName(String name) {
        for (Product p : basket) {
            if (p != null && p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                basket[i] = null;
            }
        }
    }
}
