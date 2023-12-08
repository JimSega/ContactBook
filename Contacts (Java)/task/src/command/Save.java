package command;

import contacts.PhoneBook;

import java.io.IOException;
import contacts.SerializableFile;

public class Save implements Command{
    private final PhoneBook phoneBook;
    private final String file;
    public Save(PhoneBook phoneBook, String file) {
        this.phoneBook = phoneBook;
        this.file = file;
    }
    @Override
    public void execute() {
        try {
            SerializableFile.serialize(phoneBook, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
