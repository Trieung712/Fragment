package com.test.fragment;


public class SanPham {
    private String name, price, description;
    private int image, type;

    public SanPham(String name, String price, String description, int image, int type) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }
}
