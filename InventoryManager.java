import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManager {
    private BinarySearchTree<String, Product> bySKU = new BinarySearchTree<>();
    private BinarySearchTree<String, Product> byName = new BinarySearchTree<>();

    public void addProduct(Product product) {
        bySKU.insert(product.getSKU(), product);
        byName.insert(product.getName().toLowerCase(), product);
    }

    public void loadFromCSV(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                String SKU = data[0];
                String name = data[1];
                String description = data[2];
                Map<String, Integer> sizes = new HashMap<>();
                for (String size : data[3].split("\\|")) {
                    String[] parts = size.split(":");
                    sizes.put(parts[0], Integer.parseInt(parts[1]));
                }
                Product product = new Product(SKU, name, description, sizes);
                addProduct(product);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Product findBySKU(String SKU) {
        return bySKU.search(SKU);
    }

    public Product findByName(String name) {
        return byName.search(name.toLowerCase());
    }

    public void displayProductsBySKU() {
        bySKU.inOrderTraversal();
    }

    public void displayProductsByName() {
        byName.inOrderTraversal();
    }
}

