package org.example.app;

public class Product implements Cloneable{
    private int id;
    private String type;
    private String description;
    private double price;
    private int quantity;
    private String img;

    public Product() {}

    public Product (int id, String description, double price) {
        this(id, description, price, 0, "");
    }

    public Product (String description, double price, int quantity, String img) {
        this(0, description, price, quantity, img);
    }

    public Product (int id, String description, double price, int quantity, String img) {
        this(0, "Component", description, price, quantity, img);
    }

    public Product(int id, String type, String description, double price, int quantity, String img) {
        this.id = id;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.description + " " + this.price + " " + this.quantity + " " + this.img;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override public boolean equals (Object obj) {
        if (!(obj instanceof Product)) {
            return false;
        }
        return ((Product)obj).getId() == this.getId();
    }
}
