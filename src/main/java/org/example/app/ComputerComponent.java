package org.example.app;

public class ComputerComponent extends ComputerDecorator {
    private String description;
    private double price;

    public ComputerComponent(Computer computer) {
        super(computer);
    }

    public ComputerComponent(Computer computer, String description, double price) {
        super(computer);
        this.description = description;
        this.price = price;

        // TBC: handle components and quantity
    }

    @Override
    public String getDescription() {

        return super.getDescription() + " + " + this.description;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.price;
    }
}
