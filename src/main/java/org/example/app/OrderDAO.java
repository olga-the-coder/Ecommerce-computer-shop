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

    public void create(Order order) throws SQLException {
        String query = "INSERT INTO productOrder VALUES (?, ?, ?, ?)";

        Connection conn = datasource.getConnection();
        PreparedStatement stat = conn.prepareStatement(query);
        stat.setString(1, order.getId());
        stat.setString(2, order.getDescription());
        stat.setFloat(3, order.getTotal());
        stat.setTimestamp(4, Timestamp.valueOf(order.getDateTime()));
        stat.executeUpdate();

        conn.close();
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

}
