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
                case 5:
                    all();
                    break;
                case 6:
                    return;
            }
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
        Product product = new Product("new product", 9.99, 100, "new image");
        service.create(product);
    }

    private void all() {
        for (Product product: service.getProducts()) {
            System.out.println(product);
        }
    }

}
