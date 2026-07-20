package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.io.LineNumberInputStream;
import java.util.*;

public class ProductBasket {

    HashMap<String, LinkedList<Product>> basket = new HashMap();
//    List<Product> basket = new LinkedList<>();


    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public HashMap deleteProductByName(String name) {
        basket.remove(name);
        return basket;
    }

//    public LinkedList deleteProductByName(String name) {
//        Iterator<Product> iterator = basket.iterator();
//        LinkedList<Product>  deletedProducts= new LinkedList<>();
//        while (iterator.hasNext()) {
//           Product product = iterator.next();
//            if (product.getName().equalsIgnoreCase(name)) {
//                deletedProducts.add(product);
//                iterator.remove();
//            }
//        } return deletedProducts;
//    }


    public int sumUpThePrice() {
        int sum = 0;
        for (List<Product> products : basket.values()) {
            for (Product p : products) {
                if (p != null) {
                    sum += p.getPrice();
                }
            }
        }
        return sum;
    }

    public void printBasket() {
        boolean isEmpty = true;
        int counter = 0;
        for (List<Product> products : basket.values()) {
            for (Product p : products) {
                if (p != null) {
                    isEmpty = false;
                    System.out.println(p);
                    if (p.isSpecial()) {
                        counter++;
                    }
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
        for (List<Product> products : basket.values()) {
            for (Product p : products) {
                if (p != null && p.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<Product> getProductsToDelete(String name) {
        List<Product> productsToDelete = new LinkedList<>();
        if (basket.containsKey(name)) {
            productsToDelete.addAll(basket.get(name));
        }
        return productsToDelete;
    }
}

