package com.example.paymentwithpaypal;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.paymentwithpaypal.Models.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private ArrayList<CartItem> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }
    public void clearCart() {
        cartItems.clear();
    }

    public void addToCart(String name, int imageResource, double price, int quantity, String category) {
        cartItems.add(new CartItem(name, imageResource, price, quantity, category));
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }
}
