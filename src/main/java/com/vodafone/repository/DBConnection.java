package com.vodafone.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    final static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CardsInfo", "root", "P@ssw0rd");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
