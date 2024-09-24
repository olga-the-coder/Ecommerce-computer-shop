package org.example.app;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String id;
    private String description;
    private double total;
    private LocalDateTime dateTime;
    List<Product> products;


    public Order(String id, String description, double total, LocalDateTime dateTime, List<Product> products) {
        this.id = id;
        this.description = description;
        this.total = total;
        this.dateTime = dateTime;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", total=" + total +
                ", dateTime=" + dateTime +
                ", products=" + products +
                '}';
    }
}

