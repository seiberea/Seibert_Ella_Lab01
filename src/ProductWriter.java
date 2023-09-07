import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();
        Scanner sc = new Scanner(System.in);
        do {

            String id = SafeInput.getNonZeroLenString(sc, "Please enter an ID");
            String name = SafeInput.getNonZeroLenString(sc, "Please enter a name");
            String description = SafeInput.getNonZeroLenString(sc, "Please enter a description");
            double cost = SafeInput.getDouble(sc, "Please enter the cost");

            Product product = new Product(id, name, description, cost);
            products.add(product);


        } while (SafeInput.getYNConfirm(sc, "Do you want to add another product?"));

        try {
            FileWriter writer = new FileWriter("ProductTestData.txt");
            for (Product product: products) {
                writer.write(product.toCSV() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
