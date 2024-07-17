package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DataSourceFactory {

    private static DataSourceFactory instance = new DataSourceFactory("src/main/resources/db.properties");
    private Properties props;

    private DataSourceFactory(String fname) {
        props = new Properties();
        try {
            props.load(new FileInputStream("src/main/resources/db.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static DataSourceFactory getInstance() {
        return DataSourceFactory.instance;
    }


    public DataSource getDataSource() {
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setURL(props.getProperty("DB_URL"));
        datasource.setUser(props.getProperty("DB_USER"));
        datasource.setPassword(props.getProperty("DB_PASSWORD"));

        return datasource;
    }

    public static void main(String[] args) {
        DataSource ds = DataSourceFactory.getInstance().getDataSource();
        Connection conn = null;
        String query = "SELECT * FROM product";


        try {
            conn = ds.getConnection();
            Statement stat = conn.createStatement();
            //DataSourceFactory.getInstance().getDataSource();
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getString(2));
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect to db");
        }
    }

}
