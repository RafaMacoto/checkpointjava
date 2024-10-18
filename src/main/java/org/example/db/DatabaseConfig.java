package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static String user = "rm554992";
    private static String password = "280806";
    private static Connection connection;

    private DatabaseConfig() {}

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseConfig.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(
                                url, user, password
                        );
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());;
                    }
                }
            }
        }
        return connection;
    }
}

