/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DatabaseConnection;
import Model.User;
import java.sql.*;

public class UserController {

    public static User login(String username, String password) {
        User user = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("user_id"), rs.getString("username"),
                        rs.getString("password"), rs.getString("role"));
                // Redirect based on role
                if (user.getRole().equals("Barista")) {
                    new View.BaristaDashboard().setVisible(true);
                } else if (user.getRole().equals("Manager")) {
                    new View.ManagerDashboard().setVisible(true);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Invalid credentials!");
            }
        } catch (SQLException e) {
        }
        return user;
    }
}

