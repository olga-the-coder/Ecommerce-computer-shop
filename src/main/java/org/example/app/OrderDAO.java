package org.example.app;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private DataSource datasource;

    public OrderDAO() {
        this.datasource = DataSourceFactory.getInstance().getDataSource();
    }

    public int create(Order order) throws SQLException {
        String query = "INSERT INTO productOrder VALUES(?, ?, ?, ?)";
        String query2 = "INSERT INTO orderDetails VALUES(?, ?, ?)";

        Connection conn = datasource.getConnection();
        int rows;

        //Manage transaction
        conn.setAutoCommit(false);

        // insert into order table

        PreparedStatement stat = conn.prepareStatement(query);
        stat.setString(1, order.getId());
        stat.setString(2, order.getDescription());
        stat.setFloat(3, order.getTotal());
        stat.setTimestamp(4, Timestamp.valueOf(order.getDateTime()));
        rows = stat.executeUpdate();

        // insert into orderDetails table
        stat = conn.prepareStatement(query2);
        for (Product product: order.getProducts()) {
            stat.setString(1, order.getId());
            stat.setInt(2, product.getId());
            stat.setInt(3, product.getQuantity());
            rows += stat.executeUpdate();
        }

        conn.commit(); // execute multiple requests in a single transaction
        conn.close();

        return rows;
    }

    public List<Order> readAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM productOrder";

        Connection conn = datasource.getConnection();
        Statement stat = conn.createStatement();
        //DataSourceFactory.getInstance().getDataSource();
        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            Order order = new Order(rs.getString(1), rs.getNString(2), rs.getFloat(3),
                    rs.getTimestamp(4).toLocalDateTime(), new ArrayList<Product>());
            orders.add(order);
            //System.out.println(rs.getString(2));
        }
        conn.close();
        return orders;
    }

    public Order read(String id) throws SQLException {
        Order order = null;
        String query = "SELECT * FROM productOrder WHERE id='" + id + "'";

        Connection conn = datasource.getConnection();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(query);

        if (rs.next())
            order = new Order(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getTimestamp(4).toLocalDateTime(),
                    new ArrayList<Product>());

        conn.close();
        return order;
    }

    public int update (Order order) throws SQLException {
        String query = "UPDATE productOrder SET description = ?, total = ?, date_time =? WHERE id = ?";
        int rows = 0;

        Connection conn = datasource.getConnection();

        PreparedStatement stat = conn.prepareStatement(query);
        stat.setString(1, order.getDescription());
        stat.setFloat(2, order.getTotal());
        stat.setTimestamp(3, Timestamp.valueOf(order.getDateTime()));
        stat.setString(4, order.getId());
        rows = stat.executeUpdate();

        conn.close();

        return rows;
    }

    public int delete(String id) throws SQLException {
        Connection conn = datasource.getConnection();
        int rows = 0;

        String query = "DELETE FROM productOrder WHERE id='" + id + "'";

        Statement stat = conn.createStatement();
        rows = stat.executeUpdate(query);

        conn.close();
        return rows;
    }

}
