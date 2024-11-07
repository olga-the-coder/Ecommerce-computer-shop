package org.example.app;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

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
}
