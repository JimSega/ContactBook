package command;

import contacts.PhoneBook;

class CountCommand implements Command {
    private PhoneBook phoneBook;
    public CountCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    public void execute() {
        this.phoneBook.count();
    }
}
