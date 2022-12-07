import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final String FILE_NAME = "products.txt";
    public static void main(String[] args) {
        try {
            Product[] products = getData(FILE_NAME);
            // sort the products based on the Comparable interface 
            Arrays.sort(products);
            for (int i = 0; i < products.length; i++) {
                System.out.println(products[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Product[] getData(String filename) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        Scanner scan = new Scanner(fis);
        Product[] products = new Product[18];
        for (int i = 0; scan.hasNextLine(); i++) {
            String type = scan.next();
            switch (type) {
                case "PANTS":
                    products[i] = new Pants(scan.nextInt(), scan.nextDouble(), scan.next(), scan.next());
                    break;
                case "SHIRT":
                    products[i] = new Shirt(Shirt.Size.valueOf(scan.next()), scan.nextDouble(), scan.next(), scan.next());
                    break;
                default:
                    break;
            }
        }
        scan.close();
        return products;
    }

}
