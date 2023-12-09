package command;

import contacts.Contact;
import java.util.ArrayList;

class InfoCommand implements Command {
    private final ArrayList<Contact> searchArray;
    private final int i;
    public InfoCommand(ArrayList<Contact> searchArray, int i) {
        this.searchArray = searchArray;
        this.i = i;
    }
    public void execute() {
        System.out.println(searchArray.get(i));
    }
}
