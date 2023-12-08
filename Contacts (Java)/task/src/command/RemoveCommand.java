package command;

import contacts.PhoneBook;

class RemoveCommand implements Command {
    private PhoneBook phoneBook;
    private int index;
    public RemoveCommand(PhoneBook phoneBook, int index) {
        this.phoneBook = phoneBook;
        this.index = index;
    }
    public void execute() {
        this.phoneBook.remove(this.index);
    }
}
