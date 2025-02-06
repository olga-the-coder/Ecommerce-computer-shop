package org.example.console;

import org.example.app.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class MarketSpace {
    private static MarketSpace instance = new MarketSpace();
    private Map<Integer, Product> products;
    private List<Computer> cart = new ArrayList<>();

    //private constructor to make sure we can only create instance inside this class
    private MarketSpace() {
        products = new HashMap<>();
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
        while(true) {
            System.out.printf("\nCurrent Build: %s, and total price is %.1f\n", computer.getDescription(), computer.getPrice());
            System.out.println("What component would you like to add?");
            menu();
            //System.out.println(-1 + ":Done");

            c = sc.nextInt();
            if (c == 0)
                break;
            else if (!products.containsKey(c)) {
                System.out.println("Invalid input: " + c);
                continue;
            }

            Product product = products.get(c);

            if (product.getQuantity() > 0) {
                Product p = new Product();
                try {
                    p = (Product)product.clone();
                    p.setQuantity(1);
                } catch (CloneNotSupportedException ex) {
                    ex.printStackTrace();
                }

                computer = new ComputerComponent(computer, p);
                product.setQuantity(product.getQuantity() - 1);
            } else {
                System.out.println(product.getDescription() + " is out of stock! Please order different product!");
            }

        }
        cart.add(computer);
        System.out.println((ComputerComponent) computer);
    }


   /* public void loadProducts(String fname) {
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
    } */

    public void loadProducts() {
        ProductService service = new ProductService();
        for (Product product: service.getProducts() )
            this.products.put(product.getId(), product);
    }

    public List<Computer> getCart() {
        return cart;
    }

    private void menu() {
        products.forEach((k, v) -> System.out.println(v));
        System.out.println(0 + ":Done");
        System.out.println(-1 + ":Cancel");
    }
}
