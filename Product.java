import java.util.Map;

public class Product {
    private String SKU;
    private String name;
    private String description;
    private Map<String, Integer> sizes;

    public Product(String SKU, String name, String description, Map<String, Integer> sizes) {
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.sizes = sizes;
    }

    public String getSKU() { return SKU; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Map<String, Integer> getSizes() { return sizes; }

    public String toString() {
        return SKU + " | " + name + " | " + description + " | " + sizes;
    }
}


