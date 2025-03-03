package org.example.app;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ComputerBase implements Computer {
    //public static final String NAME = "Default Computer";
    //public static final double PRICE = 700.0;
    public static final int SIZE = 100;
    private static List<Integer> ids = new Random(). ints(1, SIZE + 1).distinct().limit(SIZE).boxed().collect(Collectors.toList());

    private String orderID;
    private String description;
    private double price;
    private List<Product> components;

    public ComputerBase() {
        Product computer = new ProductService().getComputer();
        this.orderID = getID();
        this.description = computer.getDescription();
        this.price = computer.getPrice();
        this.components = new ArrayList<Product>();
    }
    public ComputerBase(String orderID, String description, double price, List<Product> components) {
        this.orderID = orderID;
        this.description = description;
        this.price = price;
        this.components = components;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getOrderID() {
        return this.orderID;
    }

    @Override
    public List<Product> getComponents() {
        return this.components;
    }

    @Override
    public String toString() {
        return "ComputerBase{" +
                "orderID='" + orderID + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", components=" + components +
                '}';
    }


    private static String getID() {
        return Integer.toString(ids.remove(0));
    }
}
