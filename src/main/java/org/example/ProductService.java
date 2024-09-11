package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private ProductDAO dao;

    public ProductService() {
        dao = new ProductDAO();
    }

    public void create(Product product) {
        try {
           dao.create(product);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

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

}
