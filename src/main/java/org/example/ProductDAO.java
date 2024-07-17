package org.example;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DataSource datasource;

    public ProductDAO() {
        this.datasource = DataSourceFactory.getInstance().getDataSource();
    }

    public List<Product> readAll() throws SQLException{
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        String query = "SELECT * FROM product";

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