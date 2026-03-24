package org.swsc.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/swsc_db";
        String user = "postgres";
        String password = "prabita";
        return DriverManager.getConnection(url, user, password);

    }
}
