package assignment1;
import java.util.Arrays;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {

    public static void main(String[] args) {
        // Create an array of Product objects using sample data
        Product[] products = {
                new Product(3128874119L, "Banana", LocalDate.of(2023, 1, 24), 124, 0.55),
                new Product(2927458265L, "Apple", LocalDate.of(2022, 12, 9), 18, 1.09),
                new Product(9189927460L, "Carrot", LocalDate.of(2023, 3, 31), 89, 2.99)
        };

        // Call the printProducts method
        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        // Sort products by name using Stream API
        Product[] sortedProducts = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName))
                .toArray(Product[]::new);

        System.out.println("\n--- Products in JSON Format ---");
        printProductsInJson(sortedProducts);

        System.out.println("\n--- Products in XML Format ---");
        printProductsInXml(sortedProducts);

        System.out.println("\n--- Products in CSV Format ---");
        printProductsInCsv(sortedProducts);
    }

    private static void printProductsInJson(Product[] products) {
        System.out.println("[");
        for (int i = 0; i < products.length; i++) {
            Product p = products[i];
            System.out.println("  {");
            System.out.println("    \"productId\": " + p.getProductId() + ",");
            System.out.println("    \"name\": \"" + p.getName() + "\",");
            System.out.println("    \"dateSupplied\": \"" + p.getDateSupplied() + "\",");
            System.out.println("    \"quantityInStock\": " + p.getQuantityInStock() + ",");
            System.out.println("    \"unitPrice\": " + p.getUnitPrice());
            System.out.print("  }");
            if (i < products.length - 1) System.out.println(",");
            else System.out.println();
        }
        System.out.println("]");
    }

    private static void printProductsInXml(Product[] products) {
        System.out.println("<products>");
        for (Product p : products) {
            System.out.println("  <product>");
            System.out.println("    <productId>" + p.getProductId() + "</productId>");
            System.out.println("    <name>" + p.getName() + "</name>");
            System.out.println("    <dateSupplied>" + p.getDateSupplied() + "</dateSupplied>");
            System.out.println("    <quantityInStock>" + p.getQuantityInStock() + "</quantityInStock>");
            System.out.println("    <unitPrice>" + p.getUnitPrice() + "</unitPrice>");
            System.out.println("  </product>");
        }
        System.out.println("</products>");
    }

    private static void printProductsInCsv(Product[] products) {
        System.out.println("productId,name,dateSupplied,quantityInStock,unitPrice");
        for (Product p : products) {
            System.out.println(p.getProductId() + "," + p.getName() + "," + p.getDateSupplied() + "," + p.getQuantityInStock() + "," + p.getUnitPrice());
        }
    }
}
