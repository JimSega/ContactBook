package command;

import contacts.*;

import java.time.LocalDate;

public class AddCommand implements Command {
    private final PhoneBook phoneBook;
    public AddCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    public void execute() {
        System.out.println("Enter the type (person, organization):");
        UserInput userInput = new UserInput();
        String type = userInput.getNextLine();
        switch (type.toLowerCase()) {
            case "person" -> {
                System.out.println("Enter the name:");
                String name = userInput.getNextLine();
                System.out.println("Enter the surname:");
                String surname = userInput.getNextLine();
                System.out.print("Enter the birth date:");
                String birthDate = userInput.getNextLine();
                try {
                    LocalDate.parse(birthDate);
                } catch (Exception ex) {
                    System.out.println("Bad birth date!");
                    birthDate = "[no data]";
                }
                System.out.print("Enter the gender (M, F):");
                String gender = new UserInput().getNextLine();
                if(!gender.matches("[MmFf]")) {
                    System.out.println("Bad gender!");
                    gender = "[no data]";
                }
                System.out.println("Enter the number:");
                String number = new UserInput().getNextLine();
                Contact contact = new Person.Builder()
                        .addFirstName(name)
                        .addLastName(surname)
                        .addNumber(number)
                        .addGender(gender)
                        .addBirthDate(birthDate)
                        .build();
                phoneBook.addContact(contact);
                System.out.println("The record added.");
            }
            case "organization" -> {
                System.out.println("Enter the organization name:");
                String name = userInput.getNextLine();
                System.out.println("Enter the address:");
                String address = userInput.getNextLine();
                System.out.println("Enter the number:");
                String number = userInput.getNextLine();
                Contact contact = new Organization.Builder()
                        .addName(name)
                        .addAddress(address)
                        .addNumber(number)
                        .build();
                phoneBook.addContact(contact);
                System.out.println("The record added.");
            }
            default -> System.out.println("Wrong type");
        }
    }
}