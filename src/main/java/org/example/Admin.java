package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Admin {
    private static Admin instance = new Admin();
    private Scanner sc;
    private ProductService service;

    private Admin() {
        sc = new Scanner(System.in);
        service = new ProductService();
    }

    public static Admin instance() {
        return instance;
    }

    public void admin() {
        while(true) {
            menu();
            int c = sc.nextInt();
            switch(c) {
                case 1:
                   create();
                   break;
                case 2:
                    get();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    all();
                    break;
                case 6:
                    return;
            }
            sc.nextLine(); //consume \n
        }
    }

    public void menu() {
        String[] adminMenu = {
                "1: Create",
                "2: Read",
                "3: Update",
                "4: Delete",
                "5: All products",
                "6: Quit"
        };

        // for (String menu: adminMenu)
        //System.out.println(menu);

        System.out.println("\n*** Product Admin ***");
        Arrays.stream(adminMenu).forEach(System.out::println); // functional programming
    }

    private void create() {
        /*System.out.println("Please enter product description");
        String desc = sc.nextLine();
        sc.next();
        System.out.println("Please enter product price");
        sc.next();
        double price = sc.nextDouble();
        System.out.println("Please enter product quantity");
        int quantity = sc.nextInt();
        System.out.println("Please enter product image");
        String img = sc.nextLine();
        Product product = new Product(desc, price, quantity, img);
        service.create(product); */

        System.out.print("Please enter product description: ");
        sc.nextLine();
        String desc = sc.nextLine();
        System.out.print("Please enter product price: ");
        double price = sc.nextDouble();
        System.out.print("Please enter product quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Please enter product image: ");
        String img = sc.nextLine();
        Product product = new Product(desc, price, quantity, img);
        service.create(product);
    }

    private void all() {
        /*for (Product product: service.getProducts()) {
            System.out.println(product);
        } */

        service.getProducts().forEach(System.out::println);
    }

    private void get() {
        System.out.println("Which product would you like to get?");
        int c =sc.nextInt();
        /*for (Product product: service.getProducts()) {
            System.out.println(product);
        } */
        System.out.println(service.getProduct(c));

    }

    public void delete() {
        System.out.println("Which product would you like to delete?");
        int c = sc.nextInt();
        service.deleteProduct(c);
    }

}
