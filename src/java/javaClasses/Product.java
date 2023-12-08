package javaClasses;

/**
 *
 * @author raj94
 */
public class Product {
    private int prodId;
    private String prodName;
    private String descp;
    private int price;
    private String image;
    private String category;

    public Product() {
    }

    public Product(String prodName, String descp, int price, String image, String category) {
        this.prodName = prodName;
        this.descp = descp;
        this.price = price;
        this.image = image;
        this.category = category;
    }
    
    
    public Product(int prodId, String prodName, String descp, int price, String image, String category) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.descp = descp;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getDescp() {
        return descp;
    }

    public String getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    public int getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    @Override
    public String toString() {
        return "Product{" + "prodId=" + prodId + ", prodName=" + prodName + ", descp=" + descp + ", price=" + price + ", image=" + image + ", category=" + category + '}';
    }
    
}
