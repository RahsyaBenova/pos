package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionDatabase {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/inventory";
    private static ConnectionDatabase instance;
    private Properties prop;
    private Connection conn;
    private ConnectionDatabase() {
        try {
            prop = new Properties();
            prop.loadFromXML(new FileInputStream("src/Database/DBCredentials.xml"));
            Class.forName(driver);
            conn = DriverManager.getConnection(url, prop.getProperty("username"), prop.getProperty("password"));
        } catch (Exception e) {
            throw new RuntimeException("Error initializing connection factory", e);
        }
    }
    public static ConnectionDatabase getInstance() {
        if (instance == null) {
            synchronized (ConnectionDatabase.class) {
                if (instance == null) {
                    instance = new ConnectionDatabase();
                }
            }
        }
        return instance;
    }
    public Connection getConnection() {
        return conn;
    }
    public boolean checkLogin(String username, String password) {
        String query = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "' LIMIT 1";
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            return resultSet.next();
        } catch (Exception ex) {
            throw new RuntimeException("Login verification failed", ex);
        }
    }
}