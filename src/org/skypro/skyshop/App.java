package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product bread = new Product("Батон <<Красная цена, нарезка>>", 30);
        Product milk = new Product("Молоко <<Станция молочная>>", 85);
        Product sausage = new Product("Колбаса <<Вязанка>>", 300);
        Product cheese = new Product("Сыр <<Liebendorf>>", 220);
        Product chocolate = new Product("Шоколад <<Россия - Щедрая душа>>", 80);
        Product chips = new Product("Чипсы <<Lay\\'s>>", 175);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(sausage);
        basket.addProduct(cheese);
        basket.addProduct(chocolate);
        basket.addProduct(chips);

        System.out.println(basket.printBasket());

        System.out.println(basket.getFullPrice() + "руб.");

        System.out.println(basket.checkProductByName("Колбаса <<Вязанка>>"));

        System.out.println(basket.checkProductByName("Колбаса <<Папа может>>"));

        basket.clear();

        System.out.println(basket.printBasket());

        System.out.println(basket.getFullPrice() + "руб.");

        System.out.println(basket.checkProductByName("Колбаса <<Вязанка>>"));

    }
}