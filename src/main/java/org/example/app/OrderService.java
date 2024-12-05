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

    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();

        try {
            orders = dao.readAll();
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return  orders;
    }

    public Order getOrder(String id) {
        Order order = null;
        try {
            order = dao.read(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }

    public  int deleteOrder(String id) {
        int rows = 0;
        try {
            rows = dao.delete(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rows;
    }

    public  int update(Order order) {
        int rows = 0;
        try {
            rows = dao.update(order);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rows;
    }

}
