package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.Searchable;
import org.skypro.skyshop.searchengine.SearchEngine;

public class App {
    public static void main(String[] args) {
        Product bread = new SimpleProduct(null, 0);
        System.out.println(bread);
        Product milk = new DiscountedProduct("", 0, 101);
        System.out.println(milk);
        Product sausage = new FixPriceProduct("КолбасаКолбасаКолбасаКолбаса <<Вязанка>>");
        System.out.println(sausage);
        Product cheese = new SimpleProduct("Сыр <<Liebendorf>>", 220);
        System.out.println(cheese);
        Product chocolate = new DiscountedProduct("Шоколад <<Россия - Щедрая душа>>", 80, 50);
        System.out.println(chocolate);
        Product chips = new SimpleProduct("Чипсы <<Lay\\'s>>", 175);
        System.out.println(chips);
        Article sausageSecond = new Article("Колбаса <<Папа может>>", "Одна из тех кооооооооооолбас что мне нравиться");
        System.out.println(sausageSecond);
        Article sausageThird = new Article("Колбаса <<Дугушка>>", "Постоянно её беру");
        System.out.println(sausageThird);
        System.out.println();

        SearchEngine searchables = new SearchEngine(10);
        searchables.add(bread);
        searchables.add(milk);
        searchables.add(sausage);
        searchables.add(cheese);
        searchables.add(chocolate);
        searchables.add(chips);
        searchables.add(sausageSecond);
        searchables.add(sausageThird);
        try {
            System.out.println(searchables.search("Колбасу"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            Searchable searchingTmp = searchables.search("о");
            System.out.println(searchingTmp);
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}