package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static DB instance;
    private Connection connection;

    private final String URL = "jdbc:postgresql://localhost:5432/testdb";
    private final String USER = "hamza";
    private final String PASSWORD = "hamza";

    // Private constructor to prevent instantiation
    private DB() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DB getInstance() {
        if (instance == null) {
            synchronized (DB.class) {
                if (instance == null) {
                    instance = new DB();
                }
            }
        }
        return instance;
    }

    // Get the connection
    public Connection getConnection() {
        return connection;
    }
}

