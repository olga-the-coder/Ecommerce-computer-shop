package org.example;

public class Product {
    private int id;
    private String description;
    private double price;
    private int quantity;
    private String img;

    public Product (int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Product (int id, String description, double price, int quantity, String img) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.img = img;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.description + " " + this.price;
    }
}
