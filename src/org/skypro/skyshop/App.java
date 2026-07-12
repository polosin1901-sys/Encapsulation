package org.skypro.skyshop;

import org.skypro.skyshop.Interface.Searchable;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {

    public static class Main {
        public static void main(String[] args) {

            ProductBasket basket = new ProductBasket();
            Product product1 = new SimpleProduct("Яблоко", 10);
            Product product2 = new DiscountedProduct("Банан", 20,45);
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

            DiscountedProduct discountedProduct = new DiscountedProduct("Ежевика",15, 5000);
            System.out.println(discountedProduct.getPrice());

//            Тестирование изменений (домашка к уроку - ООП: полиморфизм, интерфейсы)
            SearchEngine searchEngine = new SearchEngine(10);
            searchEngine.add(product1);
            searchEngine.add(product2);
            searchEngine.add(product3);
            searchEngine.add(product4);
            searchEngine.add(product5);
            searchEngine.add(product6);

            Searchable article1 = new Article("Яблоко","Вкусные краснодарские яблоки");
            Searchable article2 = new Article("Банан","Зелёные эквадорские бананы");
            Searchable article3 = new Article("Картофель","Молодой белорусский картофель");
            Searchable article4 = new Article("Черемша","Многолетнее травянистое растение рода Лук, самый ранний весенний источник зелени");
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);
            searchEngine.add(article4);

            Searchable[] searchables = searchEngine.search("Яблоко");
            System.out.println(Arrays.toString(searchables));
            System.out.println("- - - - - - - - - - - - - - - - - ");
            Searchable[] searchables2 = searchEngine.search("Бан");
            System.out.println(Arrays.toString(searchables2));
            System.out.println("- - - - - - - - - - - - - - - - - ");
            Searchable[] searchables3 = searchEngine.search("емша");
            System.out.println(Arrays.toString(searchables3));

        }
    }
}
