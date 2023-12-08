package command;

import contacts.PhoneBook;

class ExitCommand implements Command {
    private PhoneBook phoneBook;
    private String fileName;
    public ExitCommand(PhoneBook phoneBook, String fileName) {
        this.phoneBook = phoneBook;
        this.fileName = fileName;
    }
    @Override
    public void execute() {
        new Save(phoneBook, fileName).execute();
        phoneBook.isUsed = false;
    }
}
