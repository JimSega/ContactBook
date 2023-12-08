package command;

import contacts.PhoneBook;

class ListCommand implements Command {
    private PhoneBook phoneBook;
    public ListCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    public void execute() {
        this.phoneBook.list();
    }
}
