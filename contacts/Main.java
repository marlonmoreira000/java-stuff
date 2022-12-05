import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    private static ContactManager contactManager = new ContactManager();

    public static void main(String[] args) {
        try {
            loadContacts("contacts.txt");
            System.out.println("CONTACTS LOADED\n\n");
            System.out.println(contactManager);
            manageContacts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Process Comlpete");
        }
    }

    // prompt the user to manage the contacts in the contact manager collection
    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit");
            String ans = scan.nextLine();
            if (ans.equals("a")) {
                System.out.print("\tName: ");
                String name = scan.nextLine();
                System.out.print("\tBirth Date: ");
                String birthDate = scan.nextLine();
                System.out.print("\tPhone Number: ");
                String phoneNumber = scan.nextLine();
                if (name.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5) {
                    System.out.println("\nThe input you provided is not valid. Registration failed.");
                } else {
                    try {
                        Contact contact = new Contact(name, birthDate, phoneNumber);
                        contactManager.addContact(contact);
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("\n\nUPDATED CONTACTS\n\n" + contactManager);
                    }
                }
            } else if (ans.equals("b")) {
                System.out.println("\nWho would you like to remove?");
                String toRemove = scan.nextLine();
                contactManager.removeContact(toRemove);
                System.out.println("\n\nUPDATED CONTACTS\n\n" + contactManager);
            } else {
                break;
            }
        }
        scan.close();
    }

    // load contacts from local file and populate contact manager collection
    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            try {
                Contact contact = new Contact(scan.next(), scan.next(), scan.next());
                contactManager.addContact(contact);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        scan.close();
    }
}
