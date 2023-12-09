package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Action {
    public static boolean action(String action, PhoneBook phoneBook, Scanner scanner) {
        boolean work = true;
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
            case "list" -> {
                if(phoneBook.getPhoneBookArray().isEmpty()) {
                    System.out.println("PhoneBook isEmpty");
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    for(int i = 0; i < phoneBook.getPhoneBookArray().size(); i++) {
                        if(phoneBook.getPhoneBookArray().get(i) instanceof Person person) {
                            System.out.println((i + 1) + ". " + person.getFirstName() + " " + person.getLastName());
                            arrayList.add(person.getFirstName() + " " + person.getLastName());
                        } else if (phoneBook.getPhoneBookArray().get(i) instanceof Organization organization) {
                            System.out.println((i + 1) + ". " + organization.getName());
                            arrayList.add(organization.getName());
                        }
                    }
                    System.out.println("\n[list] Enter action ([number], back):");
                    work = secondLevel(action, scanner.nextLine(), phoneBook, scanner, arrayList);
                }
            }
            case "search" -> {
                System.out.println("Enter search query:");
                String search = scanner.nextLine();
                ArrayList<Contact> searchArray = phoneBook.search(search);
                if(!searchArray.isEmpty()) {
                    System.out.printf("Found %d results:\n", searchArray.size());
                    for(int i = 0; i < searchArray.size(); i++) {
                        System.out.println(i + 1 + ". " + searchArray.get(i));
                    }
                } else System.out.println("Found 0 result:");
                System.out.println("[search] Enter action ([number], back, again):");
                String secondLevel = scanner.nextLine();
                //secondLevel(action, secondLevel, phoneBook, scanner, searchArray);
            }
        }
        return work;
    }
    public static boolean secondLevel(String action, String secondAction, PhoneBook phoneBook, Scanner scanner,
                                   ArrayList<String> searchArray) {
        boolean work = true;
        switch (secondAction.toLowerCase()) {
            case "again" -> Action.action(action, phoneBook,scanner);
            case "menu" -> {
            }
            case "exit" -> work = false;
            case "back" -> {

            }
            default -> {
                int i;
                try {
                    i = Integer.parseInt(secondAction) - 1;
                } catch (Exception ex) {
                    System.out.println("Wrong case");
                    break;
                }
                if(i >= 0 && i < searchArray.size()) {
                    System.out.println(phoneBook.getPhoneBookArray().get(i).toString());
                    System.out.println("[record] Enter action (edit, delete, menu):");
                    work = secondLevel(action, scanner.nextLine(), phoneBook, scanner, i);
                } else System.out.println("Wrong index list!");
            }
        }
        return work;
    }
    public static boolean secondLevel(String action, String secondAction, PhoneBook phoneBook, Scanner scanner, int i) {
        boolean work = true;
        switch (secondAction.toLowerCase()) {
            case "menu" -> {
                if (!action.equalsIgnoreCase("search")) {
                    work = action(action, phoneBook, scanner);
                }
            }
            case "edit" -> {
                System.out.printf("Select a field (%s): ", phoneBook.getPhoneBookArray().get(i).getAllField());
                String fieldName = scanner.nextLine();
                System.out.printf("Enter %s:", fieldName);
                String field = scanner.nextLine();
                phoneBook.getPhoneBookArray().get(i).setField(fieldName, field);
                phoneBook.getPhoneBookArray().get(i).setLocalDateTimeEditLast(LocalDateTime.now());
                System.out.println("Saved");
                System.out.println(phoneBook.getPhoneBookArray().get(i));
                System.out.println("\n[record] Enter action (edit, delete, menu):");
                secondLevel(action, scanner.nextLine(), phoneBook, scanner, i);
            }
            case "delete" -> {
                if(phoneBook.getPhoneBookArray().remove(i).hasNumber()) {
                    System.out.println("The record removed!");
                } else System.out.println("Wrong index");
            }
        }
        return work;
    }
}
