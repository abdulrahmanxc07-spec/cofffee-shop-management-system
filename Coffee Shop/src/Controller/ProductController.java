/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Model.Product;
import Model.ProductDAO;
import java.util.ArrayList;

public class ProductController {

    private final ProductDAO productDAO = new ProductDAO();

    public boolean addProduct(Product p) {
        return productDAO.addProduct(p);
    }

    public Product searchProduct(String id) {
        return productDAO.searchProduct(id);
    }

    public ArrayList<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}
