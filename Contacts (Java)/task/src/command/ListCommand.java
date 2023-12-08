package command;

import contacts.Organization;
import contacts.Person;
import contacts.PhoneBook;

import java.util.ArrayList;

public class ListCommand implements Command {
    private final PhoneBook phoneBook;
    public ListCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    public void execute() {
        if(phoneBook.getPhoneBookArray().isEmpty()) {
            System.out.println("PhoneBook isEmpty");
        } else {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < phoneBook.getPhoneBookArray().size(); i++) {
                if (phoneBook.getPhoneBookArray().get(i) instanceof Person person) {
                    System.out.println((i + 1) + ". " + person.getFirstName() + " " + person.getLastName());
                    arrayList.add(person.getFirstName() + " " + person.getLastName());
                } else if (phoneBook.getPhoneBookArray().get(i) instanceof Organization organization) {
                    System.out.println((i + 1) + ". " + organization.getName());
                    arrayList.add(organization.getName());
                }
            }
            System.out.println("\n[list] Enter action ([number], back):");
        }
    }
}
