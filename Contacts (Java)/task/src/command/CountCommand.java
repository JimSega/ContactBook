package command;

import contacts.PhoneBook;

public class CountCommand implements Command {
    private final PhoneBook phoneBook;
    public CountCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    public void execute() {
        System.out.printf("The Phone Book has %s records.\n", phoneBook.getCount());
    }
}
