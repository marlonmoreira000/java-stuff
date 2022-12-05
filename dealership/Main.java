import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        Car[] cars = new Car[] {
            new Car("Honda", 5000),
            new Car("Toyota", 12000),
        };
        cars[1].setMake("Ferrari");
        cars[1].setPrice(8500);

        Dealership dealership = new Dealership(cars);

        System.out.println("\n************* JAVA DEALERSHIP *************");
        while (true) {
            System.out.println(dealership);
            if (dealership.isEmpty()) {
                System.out.println("We're all sold out.");
                break;
            }
            System.out.print("Enter the spot number of the car you want to buy: ");
            if (!scan.hasNextInt()) {
                scan.nextLine();
                System.out.println("INVALID INPUT.");
                continue;
            }
            int spot = scan.nextInt();
            if (spot < 0 || spot >= dealership.getLength()) {
                System.out.println("INVALID INDEX.");
                continue;
            } else if (dealership.getCar(spot) == null) {
                System.out.println("EMPTY SPOT.");
                continue;
            }
            scan.nextLine();
            dealership.sell(spot);
            System.out.print("Type 'yes' to continue shopping: ");
            String continueShopping = scan.nextLine().toLowerCase();
            if (!continueShopping.equals("yes")) {
                break;
            }
        }

    //    scan.close();

    }
}
