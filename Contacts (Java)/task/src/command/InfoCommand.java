package command;

import contacts.PhoneBook;

class InfoCommand implements Command {
    private PhoneBook phoneBook;
    private int index;
    public InfoCommand(PhoneBook phoneBook, int index) {
        this.phoneBook = phoneBook;
        this.index = index;
    }
    public void execute() {
        this.phoneBook.info(this.index);
    }
}
