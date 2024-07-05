package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DataSourceFactory {

    private static DataSourceFactory instance = new DataSourceFactory();

    private DataSourceFactory() {

    }

    public static DataSourceFactory getInstance() {
        return DataSourceFactory.instance;
    }


    public DataSource getDataSource() {
        FileInputStream fis = null;
        Properties props = new Properties();
        MysqlDataSource datasource = null;

        try {
            fis = new FileInputStream("src/main/resources/db.properties");
            props.load(fis);


            datasource = new MysqlDataSource();
            datasource.setURL(props.getProperty("DB_URL"));
            datasource.setUser(props.getProperty("DB_USER"));
            datasource.setPassword(props.getProperty("DB_PASSWORD"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return datasource;
    }

    public static void main(String[] args) {
        DataSource ds = DataSourceFactory.getInstance().getDataSource();
        Connection conn = null;


        try {
            conn = ds.getConnection();
            //DataSourceFactory.getInstance().getDataSource();
            System.out.println("Connected to db");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect to db");
        }
    }

}
