package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product bread = new SimpleProduct("Батон <<Красная цена, нарезка>>", 30);
        Product milk = new DiscountedProduct("Молоко <<Станция молочная>>", 85, 10);
        Product sausage = new FixPriceProduct("Колбаса <<Вязанка>>");
        Product cheese = new SimpleProduct("Сыр <<Liebendorf>>", 220);
        Product chocolate = new DiscountedProduct("Шоколад <<Россия - Щедрая душа>>", 80, 50);
        Product chips = new SimpleProduct("Чипсы <<Lay\\'s>>", 175);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(sausage);
        basket.addProduct(cheese);
        basket.addProduct(chocolate);
        basket.addProduct(chips);

        System.out.println(basket);

        System.out.println(basket.getFullPrice() + "руб.");

        System.out.println(basket.checkProductByName("Колбаса <<Вязанка>>"));

        System.out.println(basket.checkProductByName("Колбаса <<Папа может>>"));

        basket.clear();

        System.out.println(basket);

        System.out.println(basket.getFullPrice() + "руб.");

        System.out.println(basket.checkProductByName("Колбаса <<Вязанка>>"));

    }
}