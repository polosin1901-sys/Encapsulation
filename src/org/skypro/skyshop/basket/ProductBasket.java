package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    public final Product basket[] = new Product[5];

    public void addProduct(Product product) {
        boolean added = true;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                added = false;
                break;
            }
        }
        if (added) {
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
        for (Product p : basket) {
            if (p == null) {
                System.out.println("В корзине ничего нет");
            } else {
                System.out.println(p.getName() + " : " + p.getPrice());
            }
        }
        System.out.println("Итого: " + sumUpThePrice());
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

    //    Метод для проверки пустоты корзины
    public void printIfBasketIsEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            System.out.println("Корзина пуста");
        }
    }
}
