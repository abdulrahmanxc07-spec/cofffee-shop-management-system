/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {

    // ADD PRODUCT
    public boolean addProduct(Product p) {
        String sql = "INSERT INTO products (product_id, name, price, quantity, category) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getProductId());
            stmt.setString(2, p.getProductName());
            stmt.setDouble(3, p.getPrice());
            stmt.setInt(4, p.getQuantity());
           

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error Add: " + e.getMessage());
            return false;
        }
    }

    // SEARCH PRODUCT BY ID
    public Product searchProduct(String id) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        Product product = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = new Product(
                        rs.getString("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                       
                );
            }

        } catch (SQLException e) {
            System.out.println("Search Error: " + e.getMessage());
        }

        return product;
    }

    // VIEW ALL PRODUCTS
    public ArrayList<Product> getAllProducts() {
        String sql = "SELECT * FROM products";
        ArrayList<Product> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Product(
                        rs.getString("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                    
                ));
            }

        } catch (SQLException e) {
            System.out.println("View All Error: " + e.getMessage());
        }

        return list;
    }
}
