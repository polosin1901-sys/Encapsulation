package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static class Main {
        public static void main(String[] args) {

            ProductBasket basket = new ProductBasket();
            Product product1 = new SimpleProduct("Яблоко", 10);
            Product product2 = new DiscountedProduct("Банан", 100,10);
            Product product3 = new SimpleProduct("Вишня", 30);
            Product product4 = new FixPriceProduct("Черемша");
            Product product5 = new SimpleProduct("Огурцы", 50);
            Product product6 = new SimpleProduct("Картофель", 60);

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
            basket.countingSpecialProducts();

//      Получение стоимости корзины с несколькими товарами

            System.out.println("Стоимость корзины с несколькими товарами: " + basket.sumUpThePrice());
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

            DiscountedProduct discountedProduct = new DiscountedProduct("Ежевика",420, 20);
            System.out.println(discountedProduct.getPrice());

        }
    }
}
