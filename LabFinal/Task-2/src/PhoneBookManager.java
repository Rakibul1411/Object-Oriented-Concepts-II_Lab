import java.util.*;

public class PhoneBookManager {
    private static final String FILE_NAME = "phonebook.txt";

    public static void main(String[] args) {
        List<Contact> contacts = loadContacts();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Phone Book Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(contacts, scanner);
                    break;
                case 2:
                    updateContact(contacts, scanner);
                    break;
                case 3:
                    deleteContact(contacts, scanner);
                    break;
                case 4:
                    viewContacts(contacts);
                    break;
                case 5:
                    saveContacts(contacts);
                    System.out.println("Exiting Phone Book Manager. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();


        return contacts;
    }

    private static void addContact(List<Contact> contacts, Scanner scanner) {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(firstName, lastName, email);
        contacts.add(newContact);

        System.out.println("Contact added successfully:\n" + newContact);
    }

    private static void updateContact(List<Contact> contacts, Scanner scanner) {
        viewContacts(contacts);

        System.out.print("Enter the index of the contact to update: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter new Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter new Email: ");
            String email = scanner.nextLine();

            Contact updatedContact = new Contact(firstName, lastName, email);
            contacts.set(index, updatedContact);

            System.out.println("Contact updated successfully:\n" + updatedContact);
        } else {
            System.out.println("Invalid index. No contact updated.");
        }
    }

    private static void deleteContact(List<Contact> contacts, Scanner scanner) {
        viewContacts(contacts);

        System.out.print("Enter the index of the contact to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < contacts.size()) {
            Contact deletedContact = contacts.remove(index);
            System.out.println("Contact deleted successfully:\n" + deletedContact);
        } else {
            System.out.println("Invalid index. No contact deleted.");
        }
    }

    private static void viewContacts(List<Contact> contacts) {
        System.out.println("Contacts:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(i + ". " + contacts.get(i));
        }
    }

    private static void saveContacts(List<Contact> contacts) {

}
}
