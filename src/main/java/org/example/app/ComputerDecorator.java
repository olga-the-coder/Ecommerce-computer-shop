package org.example.app;

import java.util.List;

public class ComputerDecorator implements Computer{
    private Computer computer;

    public ComputerDecorator(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String getDescription() {
        return this.computer.getDescription();
    }

    @Override
    public double getPrice() {
        return this.computer.getPrice();
    }
    @Override
    public String getOrderID() {
        return this.computer.getOrderID();
    }

    @Override
    public List<Product> getComponents() {
       return this.computer.getComponents();
    }

    @Override
    public String toString() {
        return this.getDescription() + " " + this.getPrice() + " " + this.getComponents();
    }
}
