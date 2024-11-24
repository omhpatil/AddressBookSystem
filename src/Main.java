import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add New Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(scanner, addressBook);
                    break;
                case 2:
                    addressBook.displayContacts();
                    break;
                case 3:
                    editContact(scanner, addressBook);
                    break;
                case 4:
                    deleteContact(scanner, addressBook);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Address Book. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addContact(Scanner scanner, AddressBook addressBook) {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Pin Code: ");
        int pinCode = scanner.nextInt();
        scanner.nextLine();

        Contact contact = new Contact(firstName, lastName, city, state, email, phoneNumber, pinCode);
        addressBook.addContact(contact);
        System.out.println("Contact added successfully!");
    }

    private static void editContact(Scanner scanner, AddressBook addressBook) {
        System.out.print("Enter First Name to find Contact to Edit: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name to find Contact to Edit: ");
        String lastName = scanner.nextLine();

        Contact contact = addressBook.editContact(firstName, lastName);

        if (contact != null) {
            System.out.println("Editing contact: " + contact);

            System.out.print("Enter new City ");
            String city = scanner.nextLine();
            if (!city.isBlank()) {
                contact.setCity(city);
            }

            System.out.print("Enter new State ");
            String state = scanner.nextLine();
            if (!state.isBlank()) {
                contact.setState(state);
            }

            System.out.print("Enter new Email ");
            String email = scanner.nextLine();
            if (!email.isBlank()) {
                contact.setEmail(email);
            }

            System.out.print("Enter new Phone Number ");
            String phoneNumberStr = scanner.nextLine();
            if (!phoneNumberStr.isBlank()) {
                long phoneNumber = Long.parseLong(phoneNumberStr);
                contact.setPhoneNumber(phoneNumber);
            }

            System.out.print("Enter new Pin Code ");
            String pinCodeStr = scanner.nextLine();
            if (!pinCodeStr.isBlank()) {
                int pinCode = Integer.parseInt(pinCodeStr);
                contact.setPinCode(pinCode);
            }

            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact(Scanner scanner, AddressBook addressBook) {
        System.out.print("Enter the First Name of the contact to delete: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the Last Name of the contact to delete: ");
        String lastName = scanner.nextLine();

        boolean isDeleted = addressBook.deleteContactByName(firstName, lastName);

        if (isDeleted) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
