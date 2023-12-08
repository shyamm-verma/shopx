package DataObj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javaClasses.Order;
import javaClasses.Product;

public class OrderObj {

    public OrderObj() {
    }

    public boolean insertOrder(Order ord) {
        boolean result = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx", "root", "");
                 PreparedStatement ps = con.prepareStatement("INSERT INTO orders(prodId,uid,ord_quantity,ord_date) VALUES(?,?,?,?)")) {
                ps.setInt(1, ord.getProductId());
                ps.setInt(2, ord.getUserId());
                ps.setInt(3, ord.getQuantity());
                ps.setString(4, ord.getDate());
                int i = ps.executeUpdate();
                if (i > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately.
        }
        return result;
    }

    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx", "root", "");
                 PreparedStatement ps = con.prepareStatement("SELECT * FROM orders where uid=? order by orders.ord_id desc")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Order order = new Order();
                        ProdObj prodObj = new ProdObj();
                        int pId = rs.getInt("prodId");

                        Product prod = prodObj.getSingleProduct(pId);
                        order.setOrdId(rs.getInt("ord_id"));
                        order.setProdId(pId);
                        order.setProdName(prod.getProdName());
                        order.setCategory(prod.getCategory());
                        order.setPrice(prod.getPrice() * rs.getInt("ord_quantity"));
                        order.setQuantity(rs.getInt("ord_quantity"));
                        order.setDate(rs.getString("ord_date"));
                        list.add(order);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately.
        }
        return list;
    }

    public void cancelOrder(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx", "root", "");
                 PreparedStatement ps = con.prepareStatement("DELETE from orders where ord_id=?")) {
                ps.setInt(1, id);
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately.
        }
    }
}
