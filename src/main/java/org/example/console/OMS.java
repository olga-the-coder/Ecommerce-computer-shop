package org.example.console;

import org.example.app.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OMS {
    private static OMS instance = new OMS();
    private Scanner sc;
    private OrderService service;

    private OMS() {
        sc = new Scanner(System.in);
        service = new OrderService();
    }

    public static OMS instance() {
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
                     /*
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                    */
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
                "5: All orders",
                "6: Quit"
        };

        // for (String menu: adminMenu)
        //System.out.println(menu);

        System.out.println("\n*** Order Management ***");
        Arrays.stream(adminMenu).forEach(System.out::println); // functional programming
    }

    private void create() {
        System.out.println("Please enter Order ID: ");
        sc.nextLine();
        String id = sc.nextLine();
        System.out.println("Please enter order description: ");
        //sc.next();
        String desc = sc.nextLine();
        System.out.println("Please enter order total: ");
        float total = sc.nextFloat();
        Order order = new Order(id, desc, total, LocalDateTime.now(), new ArrayList<Product>());
        service.create(order);
    }

    private void all() {
        service.getOrders().forEach(System.out::println);
    }

    private void get() {
        System.out.println("Which order would you like to get?");
        String c = sc.nextLine();
        System.out.println(service.getOrder(c));

    }
/*
    public void delete() {
        System.out.println("Which product would you like to delete?");
        int c = sc.nextInt();
        service.deleteProduct(c);
    }

    public void update() {
        String str;

        System.out.print("Which product would you like to update?");
        int id = sc.nextInt();
        sc.nextLine();
        Product product = service.getProduct(id);
        System.out.println(product);
        System.out.println("--------------");
        System.out.println("Enter without input for no change\n");

        System.out.print("Please enter up-to-date product description: ");
        sc.nextLine();
        str = sc.nextLine();
        if (!(str.isEmpty())) {
            product.setDescription(str);
        }

        System.out.print("Please enter up-to-date product price: ");
        str = sc.nextLine();
        if (!(str.isEmpty())) {
            double price = Double.parseDouble(str);
            if (price > 0 ) {
                product.setPrice(price);
            }
        }

        System.out.print("Please enter up-to-date product quantity: ");
        str = sc.nextLine();
        if (!(str.isEmpty())) {
            int quantity = Integer.parseInt(str);
            if (quantity >= 0 ) {
                product.setQuantity(quantity);
            }
        }

        System.out.print("Please enter up-to-date product image: ");
        String img = sc.nextLine();
        if (!(img.isEmpty())) {
            product.setImg(img);
        }

        //System.out.println(product);

        service.updateProduct(product);
    }
    */
    }

