public class InventoryManager {
    private BinarySearchTree<String, Product> bySKU = new BinarySearchTree<>();
    private BinarySearchTree<String, Product> byName = new BinarySearchTree<>();

    public void addProduct(Product product) {
        bySKU.insert(product.getSKU(), product);
        byName.insert(product.getName().toLowerCase(), product);
    }

    public Product findBySKU(String SKU) {
        return bySKU.search(SKU);
    }

    public Product findByName(String name) {
        return byName.search(name.toLowerCase());
    }

    public void displayProductsBySKU() {
        System.out.println("Products ordered by SKU:");
        bySKU.inOrderTraversal();
    }

    public void displayProductsByName() {
        System.out.println("Products ordered by Name:");
        byName.inOrderTraversal();
    }
}
