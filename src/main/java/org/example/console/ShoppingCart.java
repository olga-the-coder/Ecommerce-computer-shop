package org.example.console;

import java.util.Arrays;
import java.util.Scanner;

public class ShoppingCart {
    private static ShoppingCart instance = new ShoppingCart();
    private Scanner sc;
    private static MarketSpace marketSpace = MarketSpace.getInstance();

    private ShoppingCart() {
        sc = new Scanner(System.in);

    }

    public static ShoppingCart getInstance() {
        return instance;
    }

    public void admin() {
        while(true) {
            menu();
            int c = sc.nextInt();
            switch(c) {
                case 1:
                    System.out.println(marketSpace.getCart());
                    break;
                case 2:
                    marketSpace.sort("ID");
                    break;
                case 3:
                    marketSpace.sort("PRICE");
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
}
