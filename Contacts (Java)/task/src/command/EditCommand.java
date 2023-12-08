package command;

import contacts.PhoneBook;

class EditCommand implements Command {
    private PhoneBook phoneBook;
    private int index;
    public EditCommand(PhoneBook phoneBook, int index) {
        this.phoneBook = phoneBook;
        this.index = index;
    }
    public void execute() {
        this.phoneBook.edit(this.index);
    }
}
