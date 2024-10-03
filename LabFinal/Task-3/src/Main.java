public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

    private static List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    contacts.add(new Contact(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts from file: " + e.getMessage());
        }

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
        scanner.nextLine(); // Consume the newline character

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
        scanner.nextLine(); // Consume the newline character

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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts) {
                writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts to file: " + e.getMessage());
        }
    }
}
/*



John,Doe,john.doe@example.com
Jane,Smith,jane.smith@example.com
Bob,Johnson,bob.johnson@example.com


Phone Book Manager
1. Add Contact
2. Update Contact
3. Delete Contact
4. View Contacts
5. Exit
Enter your choice: 2
Choose how to add a contact:
1. Manual input
2. From file
Enter your choice: 2
Enter the path of the file: contacts.txt
Contact added successfully:
Name: John Doe
Email: john.doe@example.com

Contact added successfully:
Name: Jane Smith
Email: jane.smith@example.com

Contact added successfully:
Name: Bob Johnson
Email: bob.johnson@example.com



 */