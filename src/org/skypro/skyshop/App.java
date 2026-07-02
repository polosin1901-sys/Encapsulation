package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static class Main {
        public static void main(String[] args) {

            ProductBasket basket = new ProductBasket();
            Product product1 = new Product("Яблоко", 10);
            Product product2 = new Product("Банан", 20);
            Product product3 = new Product("Вишня", 30);
            Product product4 = new Product("Черемша", 40);
            Product product5 = new Product("Огурцы", 50);
            Product product6 = new Product("Картофель", 60);

//      Добавление продукта в корзину
            basket.addProduct(product1);
            basket.addProduct(product2);
            basket.addProduct(product3);
            basket.addProduct(product4);
            basket.addProduct(product5);


//      Добавление продукта в заполненную корзину, в которой нет свободного места
            basket.addProduct(product6);

//      Печать содержимого корзины с несколькими товарами
            basket.printBasket();

//      Получение стоимости корзины с несколькими товарами

            System.out.println("Стоимость корзины с ннесколькими товарами: " + basket.sumUpThePrice());
//      Поиск товара, который есть в корзине
            System.out.println(basket.checkProductName("Черемша"));


//      Поиск товара, которого нет в корзине
            System.out.println(basket.checkProductName("Кокос"));

//      Очистка корзины
            basket.clearBasket();

//      Печать содержимого пустой корзины
            basket.printBasket();

//      Получение стоимости пустой корзины
            System.out.println("Получение стоимости пустой корзины: " + basket.sumUpThePrice());

//      Поиск товара по имени в пустой корзине
            System.out.println(basket.checkProductName("Яблоко"));
        }
    }
}
