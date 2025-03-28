import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();

        // Cargar CSV
        try (Scanner sc = new Scanner(new File("inventario_ropa_deportiva_30.csv"))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                String SKU = data[0];
                String name = data[1];
                String description = data[2];
                Map<String, Integer> sizes = new HashMap<>();
                String[] sizesData = data[3].split("\\|");
                for (String sizeData : sizesData) {
                    String[] sizeQty = sizeData.split(":");
                    sizes.put(sizeQty[0], Integer.parseInt(sizeQty[1]));
                }
                Product p = new Product(SKU, name, description, sizes);
                inventory.addProduct(p);
            }
        } catch (Exception e) {
            System.out.println("Error loading CSV: " + e.getMessage());
        }

        // Uso básico:
        inventory.displayProductsBySKU();
        inventory.displayProductsByName();

        // Buscar un producto:
        Product foundBySKU = inventory.findBySKU("123");
        System.out.println("\nFound by SKU (123): " + foundBySKU);

        Product foundByName = inventory.findByName("Chumpa impermeable");
        System.out.println("\nFound by Name (Chumpa impermeable): " + foundByName);
    }
}
