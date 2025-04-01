package org.skypro.skyshop.product;

public abstract class Product {
    protected String name;

    Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n<" + name + " >";
    }
}

