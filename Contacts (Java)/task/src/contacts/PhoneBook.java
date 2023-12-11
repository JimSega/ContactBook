package contacts;

import command.EditCommand;
import command.Menu;
import command.RemoveCommand;
import command.Save;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook implements Serializable {
    private final ArrayList<Contact> phoneBookArray;
    public PhoneBook() {
        phoneBookArray = new ArrayList<>();
    }
    public ArrayList<Contact> getPhoneBookArray() {
        return phoneBookArray;
    }
    public void addContact(Contact contact) {
        phoneBookArray.add(contact);
    }
    public int getCount() {
        return phoneBookArray.size();
    }
    public int getI(Contact contact) {
        return phoneBookArray.indexOf(contact);
    }

    public ArrayList<Contact> search(String query) {
        ArrayList<Contact> resultSearch = new ArrayList<>();
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        for(Contact contact: phoneBookArray) {
            for(String str:contact.getAllField().split(", ")) {
                Matcher matcher = pattern.matcher(contact.getField(str));
                while (matcher.find()) {
                    resultSearch.add(contact);
                }
            }
        }
        return resultSearch;
    }
    public void info (int i) {
        while (true) {
            Menu recordMenu = new Menu("\n[record] Enter action");
            recordMenu.add("edit", new EditCommand(this, i))
                    .add("delete", new RemoveCommand(this, i))
                    .add("menu", new Save(this, "contacts.db"));
            String command = recordMenu.getCommandFromUser(recordMenu.toString(), new UserInput());
            recordMenu.executeCommand(command);
            if (command.equalsIgnoreCase("menu")) {
                break;
            }
        }
    }
    public void list() {
        if(phoneBookArray.isEmpty()) {
            System.out.println("PhoneBook isEmpty");
        } else {
            for (int i = 0; i < phoneBookArray.size(); i++) {
                if (phoneBookArray.get(i) instanceof Person person) {
                    System.out.println((i + 1) + ". " + person.getFirstName() + " " + person.getLastName());
                } else if (phoneBookArray.get(i) instanceof Organization organization) {
                    System.out.println((i + 1) + ". " + organization.getName());
                }
            }
        }
    }
}
