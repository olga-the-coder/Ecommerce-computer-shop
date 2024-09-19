package org.example.console;

import org.example.app.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MarketSpace {
    private static MarketSpace instance = new MarketSpace();
    private List<Product> products = new ArrayList<>();
    private List<Computer> cart = new ArrayList<>();
    private SortStrategy strategy;
    private static SortStrategy sortByOrderIDStrategy = new SortByOrderID();
    private static SortStrategy sortByPriceStrategy = new SortByPrice();

    //private constructor to make sure we can only create instance inside this class
    private MarketSpace() {
        //loadProducts("/Users/olga/IdeaProjects/EcommerceComputerShop/src/main/resources/products.csv");
        loadProducts();
    }

    public static MarketSpace getInstance() {
        return MarketSpace.instance;
    }

    public void buyComputer() {
        Computer computer = new ComputerBase();

        Scanner sc = new Scanner(System.in);
        int c;
        int size = products.size() + 1;
        while(true) {
            System.out.printf("\nCurrent Build: %s, and total price is %.1f\n", computer.getDescription(), computer.getPrice());
            System.out.println("What component would you like to add?");
            for (Product product: products) {
                System.out.println(product);
            }
            System.out.println(-1 + ":Done");

            c = sc.nextInt();
            if (c == -1)
                break;
            else if (c < 1 || c > size) {
                System.out.println("Invalid input: " + c);
                continue;
            }

            Product product = products.get(c - 1);
            //Decorator
            computer = new ComputerComponent(computer, product.getDescription(), product.getPrice());
        }
        cart.add(computer);
    }


    public void loadProducts(String fname) {
        try {
            File file = new File(fname);
            Scanner sc = new Scanner(file);
            Product product;
            int i = 1;
            String line, tokens[];
            while (sc.hasNextLine()) {
                line = sc.nextLine().strip();
                tokens = line.split(",");
                product = new Product(Integer.parseInt(tokens[0].strip()), tokens[1].strip(), Double.parseDouble(tokens[2].strip()));
                products.add(product);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + fname);
        }
    }

    public void loadProducts() {
        ProductService service = new ProductService();
            this.products = service.getProducts();
    }

    public String getCart() {
        if (cart.size() == 0) {
            return "\nNo items.";
        }
        String cartStr = "[", comma;
        for (int i = 0; i < cart.size(); i++) {
            Computer computer = cart.get(i);
            comma = i == cart.size() - 1 ? "":",";
            cartStr += String.format("OrderID@%s: %s $%.2f", computer.getOrderID(), computer.getDescription(), computer.getPrice()) + comma;
        }
        cartStr += "]";

        return cartStr;
    }

    public void sort(String s) {
        if (this.cart.isEmpty()) {
            System.out.println("\nNo items.");
            return;
        }

        if (s.equals("ID")) {
            this.strategy = sortByOrderIDStrategy;
        } else if (s.equals("PRICE")) {
            this.strategy = sortByPriceStrategy;
        }

        strategy.sort(cart);
    }
}
