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
            System.out.println("3. Exit");
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
}
