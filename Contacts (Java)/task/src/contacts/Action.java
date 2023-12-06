package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Action {
    public static void action(String action, PhoneBook phoneBook, Scanner scanner) {
        switch (action.toLowerCase()) {
            case "count" -> System.out.printf("The Phone Book has %s records.\n", phoneBook.getCount());
            case "add" -> {
                System.out.println("Enter the type (person, organization):");
                String type = scanner.nextLine();
                switch (type.toLowerCase()) {
                    case "person" -> {
                        System.out.println("Enter the name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter the surname:");
                        String surname = scanner.nextLine();
                        System.out.print("Enter the birth date:");
                        String birthDate = scanner.nextLine();
                        try {
                            LocalDate.parse(birthDate);
                        } catch (Exception ex) {
                            System.out.println("Bad birth date!");
                            birthDate = "[no data]";
                        }
                        System.out.print("Enter the gender (M, F):");
                        String gender = scanner.nextLine();
                        if(!gender.matches("[MmFf]")) {
                            System.out.println("Bad gender!");
                            gender = "[no data]";
                        }
                        System.out.println("Enter the number:");
                        String number = scanner.nextLine();
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
                        String name = scanner.nextLine();
                        System.out.println("Enter the address:");
                        String address = scanner.nextLine();
                        System.out.println("Enter the number:");
                        String number = scanner.nextLine();
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
            case "edit" -> {
                if(phoneBook.getCount() == 0) {
                    System.out.println("No records to edit!");
                } else {
                    for(int i = 0; i < phoneBook.getPhoneBookArray().size(); i++) {
                        if(phoneBook.getPhoneBookArray().get(i) instanceof Person person) {
                            System.out.println((i + 1) + ". " + person.getFirstName() + " " + person.getLastName());
                        } else if(phoneBook.getPhoneBookArray().get(i) instanceof Organization organization) {
                            System.out.println((i + 1) + ". " + organization.getName());
                        }
                    }
                    System.out.print("Select a record: ");
                    int i = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.printf("Select a field (%s): ", phoneBook.getPhoneBookArray().get(i).getAllField());
                    String fieldName = scanner.nextLine();
                    System.out.printf("Enter %s:", fieldName);
                    String field = scanner.nextLine();
                    phoneBook.getPhoneBookArray().get(i).setField(fieldName, field);
                    phoneBook.getPhoneBookArray().get(i).setLocalDateTimeEditLast(LocalDateTime.now());
                    System.out.println("Saved");
                }
            }
            case "info" -> {
                for(int i = 0; i < phoneBook.getPhoneBookArray().size(); i++) {
                    if(phoneBook.getPhoneBookArray().get(i) instanceof Person person) {
                        System.out.println((i + 1) + ". " + person.getFirstName() + person.getLastName());
                    } else if (phoneBook.getPhoneBookArray().get(i) instanceof Organization organization) {
                        System.out.println((i + 1) + ". " + organization.getName());
                    }
                }
                System.out.println("Enter index to show info:");
                int index = -1;
                try {
                    index = Integer.parseInt(scanner.nextLine());
                } catch (Exception ex) {
                    System.out.println("Wrong index");
                }
                if(index <= phoneBook.getPhoneBookArray().size() && index >= 0) {
                    System.out.println(phoneBook.getPhoneBookArray().get(index - 1));
                }
            }
            case "remove" -> {
                if(phoneBook.getPhoneBookArray().isEmpty()) {
                    System.out.println("No records to remove!");
                } else {
                    for(int i = 0; i < phoneBook.getPhoneBookArray().size(); i++) {
                        System.out.println((i + 1) + ". " + phoneBook.getPhoneBookArray().get(i).toString());
                    }
                    System.out.print("Select a record: ");
                    if(phoneBook.getPhoneBookArray().remove(scanner.nextInt() - 1).hasNumber()) {
                        scanner.nextLine();
                        System.out.println("The record removed!");
                    } else System.out.println("Wrong index");
                }


            }
        }
    }
}
