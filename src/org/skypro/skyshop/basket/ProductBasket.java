package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] basket = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getFullPrice() {
        int fullPrice = 0;
        for (Product p : basket) {
            if (p != null) {
                fullPrice += p.getPrice();
            }
        }
        return fullPrice;
    }

    public String printBasket() {
        boolean checkEmpty = true;
        for (Product p : basket) {
            if (p != null) {
                checkEmpty = false;
                break;
            }
        }
        if (!checkEmpty) {
            int specialCount = 0;
            for (Product p : basket) {
                if (p != null && p.isSpecial()) {
                    specialCount++;
                }
            }
            return Arrays.toString(basket) +
                    "\nИтого: " + getFullPrice() + "руб." +
                    "\nСпециальных товаров: " + specialCount;
        } else {
            return "В корзине пусто";
        }
    }

    public boolean checkProductByName(String name) {
        for (Product p : basket) {
            if (p != null && p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(basket, null);
    }
}
