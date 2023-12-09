package command;

import contacts.Contact;
import contacts.PhoneBook;
import contacts.UserInput;
import contacts.Person;

import java.util.ArrayList;

public class SearchCommand implements Command {
    private final PhoneBook phoneBook;
    public SearchCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    public void execute() {

        ArrayList<Contact> searchArray = phoneBook.search(askForQuery(new UserInput()));
        if(!searchArray.isEmpty()) {
            System.out.printf("Found %d results:\n", searchArray.size());
            for(int i = 0; i < searchArray.size(); i++) {
                if(searchArray.get(i) instanceof Person person) {
                    System.out.println(i + 1 + ". " + person.getFirstName() + " " + person.getLastName());
                } else System.out.println(i + 1 + ". " + searchArray.get(i).getField("name"));

            }
            Menu searchMenu = Menu.constructMenu("[search] Enter action",
                    "[number]", "back", "again");
            UserInput in = new UserInput();
            System.out.println(searchMenu);
            String command = in.getNextLine();
            if (command.matches("\\d+")) {
                int index = Integer.parseInt(command);
                searchMenu.setCommand("[number]", new InfoCommand(searchArray, index - 1));
                searchMenu.executeCommand("[number]");
                searchMenu.setCommand("[record]", new EditCommand(searchArray, index - 1));
            }
            else {
                switch (command) {
                    case "back" -> System.out.println();
                    case "again" -> {
                        searchMenu.setCommand(command, new SearchCommand(phoneBook));
                        searchMenu.executeCommand(command);
                    }
                    default -> System.out.println("Unknown command!\n");
                }
            }
        } else System.out.println("Found 0 result:");


    }

    public String askForQuery(UserInput in) {
        System.out.print("Enter search query: ");
        return in.getNextLine();
    }
}