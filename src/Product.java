import java.io.Serializable;

public class Product implements Serializable {
    private String id, name, manufacture, description;
    private int price;

    public Product() {
    }

    public Product(String id, String name, String manufacture, String description, int price) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
