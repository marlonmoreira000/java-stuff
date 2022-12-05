import java.text.ParseException;
import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<Contact>();
    }

    public Contact geContact(int index) throws ParseException {
        return new Contact(contacts.get(index));
    }

    public void setContact(int index, Contact contact) throws ParseException {
        this.contacts.set(index, new Contact(contact));
    }

    public void addContact(Contact contact) throws ParseException {
        this.contacts.add(new Contact(contact));
    }

    public void removeContact(String name) {
        if (contacts.isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.contacts.size(); i++) {
            temp += this.contacts.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
}
