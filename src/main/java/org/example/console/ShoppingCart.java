package org.example.console;

import org.example.app.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    //private static MarketSpace marketSpace = MarketSpace.getInstance();
    //private static ShoppingCart instance = new ShoppingCart();

    private SortStrategy strategy;
    private static SortStrategy sortByOrderIDStrategy = new SortByOrderID();
    private static SortStrategy sortByPriceStrategy = new SortByPrice();

    private Scanner sc;
    private List<Computer> cart;

    private OrderService service;


    public ShoppingCart(List<Computer> cart) {
        sc = new Scanner(System.in);
        this.cart = cart;
        service = new OrderService();
    }

    public void admin() {
        while(true) {
            menu();
            int c = sc.nextInt();
            switch(c) {
                case 1:
                    System.out.println(this);
                    break;
                case 2:
                    sort("ID");
                    break;
                case 3:
                    sort("PRICE");
                    break;
                case 4:
                    // checkout
                    break;
                case 5:
                    return;
            }
            sc.nextLine(); //consume \n
        }
    }

    public void menu() {
        String[] cartMenu = {
                "1: See my shopping cart",
                "2: Sort by order ID (Descending order)",
                "3: Sort by price ID (Descending order)",
                "4: Check out",
                "5: Return to main menu"
        };


        System.out.println("\n*** Shopping cart ***");
        Arrays.stream(cartMenu).forEach(System.out::println); // functional programming
    }

    // create orders for the orders in the shopping cart
    public void checkOut() {
        for (Computer computer: cart) {
       //    !!! //create order object of computer
            service.create(null);
      }

    }

    @Override
    public String toString() {
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
