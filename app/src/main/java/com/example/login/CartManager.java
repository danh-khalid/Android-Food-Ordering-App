package com.example.login;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static List<Product> cart = new ArrayList<>();

    public static void addToCart(Product product) {
        cart.add(product);
    }

    public static void removeFromCart(int index) {
        if (index >= 0 && index < cart.size()) {
            cart.remove(index);
        }
    }

    public static List<Product> getCart() {
        return cart;
    }

    public static double getTotal() {
        double total = 0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        return total;
    }
}
