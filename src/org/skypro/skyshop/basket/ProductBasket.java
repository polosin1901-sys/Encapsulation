package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.io.LineNumberInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    List<Product> basket = new LinkedList<>();


    public void addProduct(Product product) {
        basket.add(product);
    }

    public LinkedList deleteProductByName(String name) {
        Iterator<Product> iterator = basket.iterator();
        LinkedList<Product>  deletedProducts= new LinkedList<>();
        while (iterator.hasNext()) {
           Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                deletedProducts.add(product);
                iterator.remove();
            }
        } return deletedProducts;
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
        int counter = 0;
        for (Product p : basket) {
            if (p != null) {
                isEmpty = false;
                System.out.println(p);
                if (p.isSpecial()) {
                    counter++;
                }
            }
        }
        if (isEmpty) {
            System.out.println("В корзине ничего нет");
        } else {
            System.out.println("Итого: " + sumUpThePrice());
            System.out.println("Специальных товаров: " + counter);
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
        basket.clear();
    }
}
