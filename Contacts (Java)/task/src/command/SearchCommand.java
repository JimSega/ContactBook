package command;

import contacts.PhoneBook;
import contacts.UserInput;

public class SearchCommand implements Command {
    private final PhoneBook phoneBook;
    public SearchCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    public void execute() {
        phoneBook.search(askForQuery(new UserInput()));
    }

    public String askForQuery(UserInput in) {
        System.out.print("Enter search query: ");
        return in.getNextLine();
    }
}