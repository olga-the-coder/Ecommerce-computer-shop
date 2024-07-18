package org.example;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DataSource datasource;

    public ProductDAO() {
        this.datasource = DataSourceFactory.getInstance().getDataSource();
    }

    public void create (Product product) throws SQLException{
        String query = "INSERT INTO product(name, price, quantity, image) VALUES (?, ?, ?, ?)";

        Connection conn = datasource.getConnection();
        PreparedStatement stat = conn.prepareStatement(query);
        stat.setString(1, product.getDescription());
        stat.setDouble(2, product.getPrice());
        stat.setInt(3, product.getQuantity());
        stat.setString(4, product.getImg());
        stat.executeUpdate();

        conn.close();
    }

    public List<Product> readAll() throws SQLException{
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";

        Connection conn = null;
        conn = datasource.getConnection();
        Statement stat = conn.createStatement();
        //DataSourceFactory.getInstance().getDataSource();
        ResultSet rs = stat.executeQuery(query);
        while(rs.next()) {
            Product product = new Product(rs.getInt(1), rs.getNString(2), rs.getDouble(3),
                    rs.getInt(4), rs.getNString(5));
            products.add(product);
            //System.out.println(rs.getString(2));
        }
        conn.close();
        return products;
    }
}

//DAO (Data Access Object)