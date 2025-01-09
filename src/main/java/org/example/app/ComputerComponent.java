package org.example.app;

public class ComputerComponent extends ComputerDecorator {
    private String description;
    private double price;

    public ComputerComponent(Computer computer) {
        super(computer);
    }

    public ComputerComponent(Computer computer, Product product) {
        super(computer);
        this.description = product.getDescription();
        this.price = product.getPrice();

        // TBC: handle components and quantity
        //if component list has the product already, then increase its quantity by 1
        // else add product
        if (super.getComponents().contains(product)) {
            Product p = super.getComponents().get(super.getComponents().indexOf(product));
            p.setQuantity(p.getQuantity() + product.getQuantity());
        } else {
            super.getComponents().add(product);
        }
    }

    @Override
    public String getDescription() {

        return super.getDescription() + " + " + this.description;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.price;
    }

    @Override
    public String toString() {
        return "ComputerComponent{" +
                "description='" + description + '\'' +
                ", price=" + price + '\'' +
                "getComponents ='" + getComponents() +
                '}';
    }
}
