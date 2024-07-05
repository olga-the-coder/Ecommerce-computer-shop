package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Admin {
    private static Admin instance = new Admin();
    private Scanner sc;

    private Admin() {
        sc = new Scanner(System.in);
    }
    public static Admin instance() {
        return instance;
    }

    public void admin() {
        while(true) {
            menu();
            int c = sc.nextInt();
            switch(c) {
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
}
