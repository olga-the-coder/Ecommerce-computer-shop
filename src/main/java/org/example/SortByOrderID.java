package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByOrderID implements SortStrategy{
    public void sort(List<Computer> cart) {
        Comparator<Computer> comparator = new Comparator<Computer>() {
            @Override
            public int compare(Computer c1, Computer c2) {
                return c2.getOrderID().compareTo(c1.getOrderID());
            }
        };
        Collections.sort(cart, comparator);
    }
}
