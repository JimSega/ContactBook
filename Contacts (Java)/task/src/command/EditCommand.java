package command;

import contacts.PhoneBook;
import contacts.UserInput;

import java.time.LocalDateTime;

public class EditCommand implements Command {
    private final PhoneBook phoneBook;
    private final int i;
    public EditCommand(PhoneBook phoneBook, int i) {
        this.phoneBook = phoneBook;
        this.i = i;
    }
    public void execute() {
        System.out.printf("Select a field (%s): ", phoneBook.getPhoneBookArray().get(i).getAllField());
        UserInput userInput = new UserInput();
        String fieldName = new UserInput().getNextLine();
        System.out.printf("Enter %s:", fieldName);
        String field = userInput.getNextLine();
        phoneBook.getPhoneBookArray().get(i).setField(fieldName, field);
        phoneBook.getPhoneBookArray().get(i).setLocalDateTimeEditLast(LocalDateTime.now());
        System.out.println("Saved");
        System.out.println(phoneBook.getPhoneBookArray().get(i));
    }
}
