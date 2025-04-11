package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable {
    protected String name;

    Product(String name) throws RuntimeException {
        try {
            checkName(name);
        } catch (NullPointerException n) {
            System.out.println("Была переданна null");
            name = "NULL";
        } catch (RuntimeException e) {
            System.out.println("Была переданная пустота");
            name = "Пустота";
        } finally {
            this.name = name;
        }
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }

    private void checkName(String name) {
        if (name == null)
            throw new NullPointerException();
        if (name.isEmpty())
            throw new RuntimeException();
    }

    @Override
    public String toString() {
        return "\n<" + name + " >";
    }

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String searchType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return searchTerm() + " - " + searchType();
    }
}
