package command;

import contacts.PhoneBook;

public class RemoveCommand implements Command {
    private PhoneBook phoneBook;
    private int i;
    public RemoveCommand(PhoneBook phoneBook, int i) {
        this.phoneBook = phoneBook;
        this.i = i;
    }
    public void execute() {
        if(phoneBook.getPhoneBookArray().remove(i).hasNumber()) {
            System.out.println("The record removed!");
        } else System.out.println("Wrong index");
    }
}
