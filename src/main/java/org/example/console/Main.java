package org.example.console;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static MarketSpace marketSpace = MarketSpace.getInstance();
    private static ShoppingCart cart = ShoppingCart.getInstance();
    private static Admin admin = Admin.instance();
    private static OMS oms = OMS.instance();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running) {
            mainMenu();
            int c = sc.nextInt();

            switch(c) {
                case 1:
                    marketSpace.buyComputer();
                    break;
                case 2:
                    cart.admin();
                    break;
                case 3:
                    admin.admin();
                    break;
                case 4:
                    oms.admin();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    running = false;
            }
        }
        sc.close();
    }


    public static void mainMenu() {
        String[] mainMenu = {
                "Hi, what would you like to do?",
                "1: Buy a computer",
                "2: Shopping cart",
                "3: Product Admin",
                "4: Order Management",
                "5: Quit"
        };

        //for (String menu: mainMenu) {
        //   System.out.println(menu);
        //}
        Arrays.stream(mainMenu).forEach(System.out::println);
    }
}
