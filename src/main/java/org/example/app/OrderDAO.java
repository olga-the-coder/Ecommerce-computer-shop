package org.example.app;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {
    private DataSource datasource;

    public OrderDAO() {
        this.datasource = DataSourceFactory.getInstance().getDataSource();
    }

    /*public void create(Order order) throws SQLException {
        String query = "INSERT INTO product(name, price, quantity, image) VALUES (?, ?, ?, ?)";

        Connection conn = datasource.getConnection();
        PreparedStatement stat = conn.prepareStatement(query);
        stat.setString(1, product.getDescription());
        stat.setDouble(2, product.getPrice());
        stat.setInt(3, product.getQuantity());
        stat.setString(4, product.getImg());
        stat.executeUpdate();

        conn.close();
    } */
}
