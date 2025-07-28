package com.day6proj2.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "Adrin@123"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
