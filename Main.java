import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InventoryManager inventory = new InventoryManager();

        System.out.print("Ingresa el nombre del archivo CSV (ej. inventario.csv): ");
        String archivo = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || !line.contains(",")) continue;
                String[] data = line.split(",");
                if (data.length < 4) continue;

                String SKU = data[0].trim();
                String name = data[1].trim();
                String description = data[2].trim();

                Map<String, Integer> sizes = new HashMap<>();
                for (String size : data[3].split("\\|")) {
                    String[] sizeData = size.split(":");
                    if (sizeData.length == 2) {
                        sizes.put(sizeData[0].trim(), Integer.parseInt(sizeData[1].trim()));
                    }
                }
                inventory.addProduct(new Product(SKU, name, description, sizes));
            }
            System.out.println("Archivo cargado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n---- MENÚ ----");
            System.out.println("1. Mostrar listado por SKU o Nombre");
            System.out.println("2. Buscar producto por Nombre");
            System.out.println("3. Buscar producto por SKU");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(input.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("\n¿Mostrar por 1. SKU o 2. Nombre?");
                    String orden = input.nextLine();
                    if (orden.equals("1")) {
                        inventory.displayProductsBySKU();
                    } else if (orden.equals("2")) {
                        inventory.displayProductsByName();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 2:
                    System.out.print("Ingresa el Nombre a buscar: ");
                    String nombre = input.nextLine();
                    Product encontradoNombre = inventory.findByName(nombre);
                    if (encontradoNombre != null)
                        System.out.println("Encontrado: " + encontradoNombre);
                    else
                        System.out.println("Producto no encontrado.");
                    break;

                case 3:
                    System.out.print("Ingresa el SKU a buscar: ");
                    String sku = input.nextLine();
                    Product encontradoSKU = inventory.findBySKU(sku);
                    if (encontradoSKU != null)
                        System.out.println("Encontrado: " + encontradoSKU);
                    else
                        System.out.println("Producto no encontrado.");
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }

        input.close();
    }
}
