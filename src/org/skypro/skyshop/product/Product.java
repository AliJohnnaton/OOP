package org.skypro.skyshop.product;

public abstract class Product {
    String name;

    Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n<" + name + " >";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

