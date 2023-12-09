package command;

import contacts.Contact;
import contacts.UserInput;

import java.time.LocalDateTime;
import java.util.ArrayList;

class EditCommand implements Command {
    private final ArrayList<Contact> searchArray;
    private final int i;
    public EditCommand(ArrayList<Contact> searchArray, int i) {
        this.searchArray = searchArray;
        this.i = i;
    }
    public void execute() {
        System.out.printf("Select a field (%s): ", searchArray.get(i).getAllField());
        UserInput userInput = new UserInput();
        String fieldName = new UserInput().getNextLine();
        System.out.printf("Enter %s:", fieldName);

        String field = userInput.getNextLine();
        searchArray.get(i).setField(fieldName, field);
        searchArray.get(i).setLocalDateTimeEditLast(LocalDateTime.now());
        System.out.println("Saved");
        System.out.println(searchArray.get(i));
        System.out.println("\n[record] Enter action (edit, delete, menu):");
    }
}
