package org.example.app;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ComputerBase implements Computer {
    public static final String NAME = "Default Computer";
    public static final double PRICE = 700.0;
    public static final int SIZE = 100;
    private static List<Integer> ids = new Random(). ints(1, SIZE + 1).distinct().limit(SIZE).boxed().collect(Collectors.toList());

    private String orderID;
    private String description;
    private double price;

    public ComputerBase() {
        this(getID(), NAME, PRICE);
    }
    public ComputerBase(String orderID, String description, double price) {
        this.orderID = orderID;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public String getOrderID() {
        return this.orderID;
    }

    @Override
    public String toString() {
        return this.orderID + this.description + " " + this.price;
    }

    private static String getID() {
        return Integer.toString(ids.remove(0));
    }
}
