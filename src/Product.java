import java.util.Objects;

public class Product extends Menu {
    private double price;
    private double sizeupPrice;
    private String category;

    public Product(String name, String description, double price, String category) {
        super(name, description);
        this.price = price;
        this.category = category;
        this.sizeupPrice = 0;
    }
    public Product(String name, String description, double price, double sizeupPrice, String category) {
        super(name, description);
        this.price = price;
        this.sizeupPrice = sizeupPrice;
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public double getSizeupPrice() {
        return sizeupPrice;
    }
    public String getCategory() {
        return category;
    }

    @Override
    public void Show() {
        System.out.printf("%-20s | W %s |%s\n", getName(), price, getDescription());
    }
    public void Show(int EA) {
        System.out.printf("%-20s | W %s | %s개 |%s\n", getName(), price, EA, getDescription());
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product) {
            Product temp = (Product)obj;
            return this.getName().equals(temp.getName()) && this.getPrice() == temp.getPrice() && this.getSizeupPrice() == temp.getSizeupPrice() && this.getDescription().equals(temp.getDescription()) && this.getCategory().equals(temp.getCategory());
        }
        return false;
    }
    public int hashCode() {
        return Objects.hash(getName(),getDescription(),getPrice(),getSizeupPrice(),getCategory());
    }
}

