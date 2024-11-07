package org.example.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private OrderDAO dao;

    public OrderService() {
        dao = new OrderDAO();
    }

    public void create(Order order) {
        try {
           dao.create(order);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
/*
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try {
            products = dao.readAll();
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return  products;
    }

    public Product getProduct(int id) {
        Product product = null;
        try {
            product = dao.read(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public  void deleteProduct(int id) {
        try {
            dao.delete(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public  void updateProduct(Product product) {
        try {
            dao.update(product);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
*/
}
