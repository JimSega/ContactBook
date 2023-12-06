package contacts;

import java.util.ArrayList;

public class PhoneBook {
    private final ArrayList<Contact> phoneBookArray;
    public PhoneBook() {
        phoneBookArray = new ArrayList<>();
    }

    public ArrayList<Contact> getPhoneBookArray() {
        return phoneBookArray;
    }
    public void addContact(Contact contact) {
        phoneBookArray.add(contact);
    }
    public int getCount() {
        return phoneBookArray.size();
    }
}
