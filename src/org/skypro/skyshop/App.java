package org.skypro.skyshop;

import org.skypro.skyshop.Interface.Searchable;
import org.skypro.skyshop.SearchEngine.BestResultNotFound;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.sql.SQLOutput;
import java.util.*;

public class App {

    public static class Main {
        public static void main(String[] args) throws BestResultNotFound {

            ProductBasket basket = new ProductBasket();
            Product product1 = new SimpleProduct("Яблоко", 10);
            Product product2 = new DiscountedProduct("Банан", 45, 15);
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

            DiscountedProduct discountedProduct = new DiscountedProduct("Ежевика", 50, 10);
            System.out.println(discountedProduct.getPrice());

//            Тестирование изменений (домашка к уроку - ООП: полиморфизм, интерфейсы)
            SearchEngine searchEngine = new SearchEngine(new HashSet<>());
            searchEngine.add(product1);
            searchEngine.add(product2);
            searchEngine.add(product3);
            searchEngine.add(product4);
            searchEngine.add(product5);
            searchEngine.add(product6);

            Searchable article1 = new Article("Яблоко", "Вкусные краснодарские яблоки");
            Searchable article2 = new Article("Банан", "Зелёные эквадорские бананы");
            Searchable article3 = new Article("Картофель", "Молодой белорусский картофель");
            Searchable article4 = new Article("Черемша", "Многолетнее травянистое растение рода Лук, самый ранний весенний источник зелени");
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);
            searchEngine.add(article4);

            TreeSet<Searchable> searchables = searchEngine.search("Яблоко");
            for (Searchable m : searchables) {
                System.out.println(m.getName());
            }

            System.out.println("- - - - - - - - - - - - - - - - - ");
            TreeSet<Searchable> searchables2 = searchEngine.search("Бан");
            for (Searchable m : searchables2) {
                System.out.println(m.getName());
            }
            System.out.println("- - - - - - - - - - - - - - - - - ");
            TreeSet<Searchable> searchables3 = searchEngine.search("емша");
            for (Searchable m : searchables3) {
                System.out.println(m.getName());
            }
            System.out.println("- - - - - - - - - - - - - - - - - ");

//      Выполнение домашки по теме: Исключения в Java
            try {
                Product product10 = new SimpleProduct("Яблоко", 1);
                Product product11 = new DiscountedProduct("Банан", 60, 101);
            } catch (IllegalArgumentException e) {
                System.out.println("Возникла ошибка заполнения параметров продуктов - " + e.getMessage());
            }
            System.out.println("- - - - - - - - - - - - - - - - - ");
//      Демонстрация нового метода поиска
            System.out.println(searchEngine.findBestMatch("Яблоко"));
            try {
                System.out.println(searchEngine.findBestMatch("Сельдерей"));
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }
            System.out.println("1 - - - - - - - - - - - - - - - - ");
//      Выполнение домашки по теме: Java Collections Framework: List
            Product product11 = new SimpleProduct("Яблоко", 10);
            Product product21 = new DiscountedProduct("Банан", 45, 15);
            Product product31 = new SimpleProduct("Вишня", 30);
            Product product41 = new FixPriceProduct("Черемша");
            Product product51 = new SimpleProduct("Огурцы", 50);
            Product product61 = new SimpleProduct("Картофель", 60);
            basket.addProduct(product11);
            basket.addProduct(product21);
            basket.addProduct(product31);
            basket.addProduct(product41);
            basket.addProduct(product51);
            basket.addProduct(product61);
//            Удаление существующего продукта из корзины
//            basket.deleteProductByName("Яблоко");
//            Выведение удаленных продуктов на экран
            System.out.println("Выведение удаленных продуктов на экран: ");
            List<Product> productsToDelete = basket.getProductsToDelete("Яблоко");
            for (Product product : productsToDelete) {
                System.out.println(product);
            }
            basket.deleteProductByName("Яблоко");
            System.out.println("- - - - - - - - - - - - - - - - - ");
//            Выведение содержимого корзины с помощью метода printBasket
            basket.printBasket();
            System.out.println("- - - - - - - - - - - - - - - - - ");
//            Удаление несуществующего продукта

//            Проверка списка удаленных продуктов
            for (Product product : productsToDelete) {
                System.out.println(product);
            }

            System.out.println("Удалённые из корзины продукты:");
            List<Product> productsToDeleteArbuz = basket.getProductsToDelete("Арбуз");
            if (productsToDeleteArbuz.isEmpty()) {
                System.out.println("Список пуст");
            } else {
                for (Product product : productsToDeleteArbuz) {
                    System.out.println(product);
                }
            }
            System.out.println("- - - - - - - - - - - - - - - - - ");

//            Вывод содержимого корзины на экран
            basket.printBasket();
            System.out.println("- - - - - - - - - - - - - - - - - ");
//            Проверка работы компаратора
            System.out.println("Проверка работы компаратора: ");
            TreeSet<Searchable> resultSet = new TreeSet<>((s1, s2) -> {
                int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
                if (lengthCompare != 0) {
                    return lengthCompare;
                }
                return s1.getName().compareTo(s2.getName());
            });
resultSet.add(article1);
resultSet.add(article2);
resultSet.add(article3);
resultSet.add(article4);
            for (Searchable searchable : resultSet) {
                System.out.println(searchable.getName());
            }
        }
    }
}
