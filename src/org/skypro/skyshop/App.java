package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.Searchable;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product bread = new SimpleProduct("Батон <<Красная цена, нарезка>>", 30);
        Product milk = new DiscountedProduct("Молоко <<Станция молочная>>", 85, 10);
        Product sausage = new FixPriceProduct("Колбаса <<Вязанка>>");
        Product cheese = new SimpleProduct("Сыр <<Liebendorf>>", 220);
        Product chocolate = new DiscountedProduct("Шоколад <<Россия - Щедрая душа>>", 80, 50);
        Product chips = new SimpleProduct("Чипсы <<Lay\\'s>>", 175);
        Article sausageSecond = new Article("Колбаса <<Папа может>>", "Одна из тех колбас что мне нравиться");
        Article sausageThird = new Article("Колбаса <<Дугушка>>", "Постоянно её беру");

        SearchEngine searchables = new SearchEngine(10);
        searchables.add(bread);
        searchables.add(milk);
        searchables.add(sausage);
        searchables.add(cheese);
        searchables.add(chocolate);
        searchables.add(chips);
        searchables.add(sausageSecond);
        searchables.add(sausageThird);

        System.out.println(Arrays.toString(searchables.search("Колбаса")));

        System.out.println();
        Searchable[] searchingTmp;
        searchingTmp = searchables.search("о");
        for (Searchable s : searchingTmp) {
            if (s != null) {
                System.out.println(s.getStringRepresentation() + '\n');
            }
        }

    }
}