import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        final int FIELDS_LENGTH = 4;
        String rec = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(selectedFile.toPath(), CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                //int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();

                    String[] fields = rec.split(","); // Split the record into the fields

                    if(fields.length == FIELDS_LENGTH)
                    {
                        String id        = fields[0].trim();
                        String name = fields[1].trim();
                        String description     = fields[2].trim();
                        double cost       = Double.parseDouble(fields[3].trim());
                        Product product = new Product (id, name, description, cost);
                        products.add(product);
                    }
                    else
                    {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println(rec);
                    }

                }
                reader.close();
                System.out.println("\n\nData file read!");

                System.out.printf("\n%-8s%-25s%-25s%-6s", "ID#", "Name", "Description", "Cost");
                System.out.println("\n======================================================================");

                for(Product p:products)
                {
                    System.out.printf("\n%-8s%-25s%-25s%-6.2f", p.getID(), p.getName(), p.getDescription(), p.getCost());
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
