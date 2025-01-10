package com.example.application;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String HOST = "127.0.0.1"; // Veri tabanı sunucusu
    private static final String PORT = "5432"; // PostgreSQL varsayılan port numarası
    private static final String DATABASE = "banka"; // Veri tabanı ismi
    private static final String USER = "postgres"; // PostgreSQL kullanıcı adı
    private static final String PASSWORD = "1234"; // PostgreSQL şifresi

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/banka", USER, PASSWORD);
            System.out.println("Bağlantı başarılı!");
        } catch (Exception e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
        return conn;
    }
}
