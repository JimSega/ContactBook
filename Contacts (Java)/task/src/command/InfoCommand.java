package command;

import contacts.PhoneBook;

public class InfoCommand implements Command {
    private final PhoneBook phoneBook;
    private final int i;
    public InfoCommand(PhoneBook phoneBook, int i) {
        this.phoneBook = phoneBook;
        this.i = i;
    }
    public void execute() {
        System.out.println(phoneBook.getPhoneBookArray().get(i));
    }
}
