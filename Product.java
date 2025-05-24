public class Product {
    private String name;
    private double price;
    private String id;


    public Product() {
    }

    public Product(String name, double price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;

    }


    public void setProductName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getProductName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }



}
