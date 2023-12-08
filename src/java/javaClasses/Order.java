package javaClasses;

/**
 *
 * @author raj94
 */
public class Order extends Product {
    private int ordId;
    private int productId;
    private int userId;
    private int quantity;
    private String date;

    public Order() {
    }

    public Order(int ordId, int productId, int userId, int quantity, String date) {
        this.ordId = ordId;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.date = date;
    }
    
    public Order(int productId, int userId, int quantity, String date) {
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }

    public String getDate() {
        return date;
    }

    public int getOrdId() {
        return ordId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" + "ordId=" + ordId + ", productId=" + productId + ", userId=" + userId + ", quantity=" + quantity + ", date=" + date + '}';
    }
    
}
