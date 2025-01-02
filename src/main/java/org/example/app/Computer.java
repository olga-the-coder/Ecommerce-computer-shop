package org.example.app;

import java.util.List;

public interface Computer {
    String getDescription();
    double getPrice();
    String getOrderID();
    List<Product> getComponents();
}
