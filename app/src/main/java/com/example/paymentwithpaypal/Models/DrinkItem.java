package com.example.paymentwithpaypal.Models;


public class DrinkItem {
    private String name;
    private String description;
    private double price;
    private int imageResource;

    public DrinkItem(String name, String description, double price, int imageResource) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }
}
