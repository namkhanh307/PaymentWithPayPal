package com.example.paymentwithpaypal.Models;

public class CartItem {
    private String name;
    private int imageResource;
    private double price;
    private int quantity;
    private String category;

    public CartItem(String name, int imageResource, double price, int quantity, String category) {
        this.name = name;
        this.imageResource = imageResource;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }
}
