package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection{
    private final String url;
    private final int port;
    private final String dbName;
    private Connection connection;

    private static DBConnection instance;

    private DBConnection() throws SQLException {
        String name = System.getenv("postname");
        String pass = System.getenv("post_pass");
        this.dbName = "tododb";
        this.port = 5433;
        this.url = "jdbc:postgresql://localhost:" + Integer.toString(this.port) + "/" + this.dbName;
        Properties props = new Properties();
        props.setProperty("user",name);
        props.setProperty("password",pass);
        props.setProperty("ssl","false");
        this.connection = DriverManager.getConnection(url, props);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DBConnection();
        }
        else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }
}