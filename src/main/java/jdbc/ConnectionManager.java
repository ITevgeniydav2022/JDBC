package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String USER = "postgres";
    private static final String PASSWORD = "Rere!090215Cz";
    private static final String URL = "jdbc:postgresql://localhost:5432/skypro";

    private ConnectionManager() {

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
