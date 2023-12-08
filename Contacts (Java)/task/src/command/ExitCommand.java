package command;

import contacts.Main;
import contacts.PhoneBook;

public class ExitCommand implements Command {
    private final PhoneBook phoneBook;
    private final String fileName;
    public ExitCommand(PhoneBook phoneBook, String fileName) {
        this.phoneBook = phoneBook;
        this.fileName = fileName;
    }
    @Override
    public void execute() {
        new Save(phoneBook, fileName).execute();
        Main.setWork(false);
    }
}
