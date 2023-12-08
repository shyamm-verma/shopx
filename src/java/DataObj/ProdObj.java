package DataObj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javaClasses.Cart;
import javaClasses.Product;

public class ProdObj {

    public ProdObj() {
    }

    public List<Product> getAllProducts() {
        List<Product> pro = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx", "root", "");
                 PreparedStatement ps = con.prepareStatement("SELECT * FROM products");
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product row = new Product();
                    row.setProdId(rs.getInt("prodId"));
                    row.setProdName(rs.getString("prodName"));
                    row.setDescp(rs.getString("descp"));
                    row.setPrice(rs.getInt("price"));
                    row.setImage(rs.getString("image"));
                    row.setCategory(rs.getString("category"));
                    pro.add(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately.
        }
        return pro;
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> products = new ArrayList<>();

        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx", "root", "");
                         PreparedStatement ps = con.prepareStatement("SELECT * FROM products where prodId=?")) {
                        ps.setInt(1, item.getProdId());
                        try (ResultSet rs = ps.executeQuery()) {
                            while (rs.next()) {
                                Cart row = new Cart();
                                row.setProdId(rs.getInt("prodId"));
                                row.setProdName(rs.getString("prodName"));
                                row.setCategory(rs.getString("category"));
                                row.setPrice(rs.getInt("price") * item.getQuantity());
                                row.setQuantity(item.getQuantity());
                                products.add(row);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately.
        }
        return products;
    }

    public int getTotalPrice(ArrayList<Cart> cartList) {
        int sum = 0;

        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx", "root", "");
                         PreparedStatement ps = con.prepareStatement("SELECT price FROM products where prodId=?")) {
                        ps.setInt(1, item.getProdId());
                        try (ResultSet rs = ps.executeQuery()) {
                            while (rs.next()) {
                                sum += rs.getInt("price") * item.getQuantity();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately.
        }

        return sum;
    }

    public Product getSingleProduct(int id) {
        Product row = null;
        try {
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx", "root", "");
                 PreparedStatement ps = con.prepareStatement("SELECT * FROM products where prodId=?")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        row = new Product();
                        row.setProdId(rs.getInt("prodId"));
                        row.setProdName(rs.getString("prodName"));
                        row.setCategory(rs.getString("category"));
                        row.setPrice(rs.getInt("price"));
                        row.setImage(rs.getString("image"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately.
        }
        return row;
    }

    public boolean saveProductToDatabase(Product pro) {
        try {
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx", "root", "");
                 PreparedStatement ps = con.prepareStatement("INSERT INTO products(prodName,descp,price,image,category) VALUES(?,?,?,?,?)")) {
                ps.setString(1, pro.getProdName());
                ps.setString(2, pro.getDescp());
                ps.setInt(3, pro.getPrice());
                ps.setString(4, pro.getImage());
                ps.setString(5, pro.getCategory());
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately.
            return false;
        }
    }
}
