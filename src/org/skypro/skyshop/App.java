package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.Searchable;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        Product bread = new SimpleProduct("Красная цена", 24);
        System.out.println(bread);
        Product milk = new DiscountedProduct("Счастливое детство", 69, 10);
        System.out.println(milk);
        Product sausage = new FixPriceProduct("Вязанка");
        System.out.println(sausage);
        Product sausagePAPA = new FixPriceProduct("Папа Может");
        System.out.println(sausagePAPA);
        Product cheese = new SimpleProduct("Liebendorf", 220);
        System.out.println(cheese);
        Product chocolate = new DiscountedProduct("Россия - Щедрая душа", 80, 50);
        System.out.println(chocolate);
        Product chips = new SimpleProduct("Lay\\'s", 175);
        System.out.println(chips);
        Article sausageSecond = new Article("Колбаса <<Папа может>>", "Одна из тех кооооооооооолбас что мне нравиться");
        System.out.println(sausageSecond);
        Article sausageThird = new Article("Колбаса <<Дугушка>>", "Постоянно её беру");
        System.out.println(sausageThird);
        System.out.println();

        ProductBasket basket = new ProductBasket();
        basket.addProduct("Хлеб", bread);
        basket.addProduct("Молоко", milk);
        basket.addProduct("Колбаса", sausage);
        basket.addProduct("Колбаса", sausagePAPA);
        basket.addProduct("Сыр", cheese);
        basket.addProduct("Шоколад", chocolate);
        basket.addProduct("Чипсы", chips);

        System.out.println();
        System.out.println("Корзина");
        basket.printBasket();
        if (basket.checkProductByName("Колбаса")) {
            System.out.println("Есть такой продукт");
        } else {
            System.out.println("Нет такого");
        }
        System.out.println(basket.removeByName("Колбаса"));
        basket.printBasket();
        if (basket.checkProductByName("Абрикос")) {
            System.out.println("Есть такой продукт");
        } else {
            System.out.println("Нет такого");
        }
        System.out.println(basket.removeByName("Абрикос"));
        System.out.println();
        basket.clear();
        basket.printBasket();

        SearchEngine searchables = new SearchEngine();
        searchables.add(bread);
        searchables.add(milk);
        searchables.add(sausage);
        searchables.add(cheese);
        searchables.add(chocolate);
        searchables.add(chips);
        searchables.add(sausageSecond);
        searchables.add(sausageThird);
        try {
            System.out.println(searchables.search("Колбаса"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            TreeMap<String, Searchable> searchingTmp = searchables.search("о");
            System.out.println(searchingTmp);
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}