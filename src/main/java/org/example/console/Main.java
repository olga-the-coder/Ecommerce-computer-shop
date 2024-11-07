package org.example.console;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static MarketSpace marketSpace = MarketSpace.getInstance();
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
                    System.out.println(marketSpace.getCart());
                    break;
                case 3:
                    marketSpace.sort("ID");
                    break;
                case 4:
                    marketSpace.sort("PRICE");
                    break;
                case 5:
                    admin.admin();
                    break;
                case 6:
                    oms.admin();
                    break;
                case 7:
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
                "2: See my shoping cart",
                "3: Sort by order ID (Descending order)",
                "4: Sort by order price (Descending order)",
                "5: Product Admin",
                "6: Order Management",
                "7: Quit"
        };

        //for (String menu: mainMenu) {
        //   System.out.println(menu);
        //}
        Arrays.stream(mainMenu).forEach(System.out::println);
    }
}
