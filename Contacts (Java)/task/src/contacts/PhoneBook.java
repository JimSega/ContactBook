package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook implements Serializable {
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
    public ArrayList<String> search(String query) {
        ArrayList<String> resultSearch = new ArrayList<>();
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        for(Contact contact: phoneBookArray) {
            for(String str:contact.getAllField().split(", ")) {
                Matcher matcher = pattern.matcher(contact.getField(str));
                while (matcher.find()) {
                    if(contact instanceof Person) {
                        resultSearch.add(((Person) contact).getFirstName() + " " + ((Person) contact).getLastName());
                    } else resultSearch.add(contact.getField(str));
                }
            }
        }
        return resultSearch;
    }
}
