/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/Coffeeshop";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                conn = DriverManager.getConnection(URL, USER, PASSWORD);

                System.out.println("Database Connected!");
            }
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();  // ← THIS is important

        }
        return conn;
    }
}

