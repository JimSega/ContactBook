package contacts;

import java.io.File;
import java.io.IOException;
import command.*;
import command.Menu;

public class Main {
    static boolean work = true;
    public static boolean getWork() {
        return work;
    }
    public static void setWork(boolean work) {
        Main.work = work;
    }
    public static void main(String[] args) {
        File database;
        PhoneBook phoneBook;
        if(args.length == 0 || !new File(args[0]).isFile()) {
            database = new File("contacts.db");
            //for test #5 of Hyperskill
            try {
                database.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            phoneBook = new PhoneBook();
            //Hyperskill did a poor job of checking using serialization
            /*if(!database.isFile()) {
                try {
                    database.createNewFile();
                    phoneBook = new PhoneBook();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    phoneBook = (PhoneBook) SerializableFile.deserialize(database.getName());
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }*/
        } else {
            database = new File(args[0]);
            try {
                phoneBook = (PhoneBook) SerializableFile.deserialize(database.getName());
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        Menu mainMenu = new Menu("[menu] Enter action");
        mainMenu.add("add", new AddCommand(phoneBook))
                .add("list", new ListCommand(phoneBook))
                .add("search", new SearchCommand(phoneBook))
                .add("count", new CountCommand(phoneBook))
                .add("exit", new ExitCommand(phoneBook, "contacts.db"));
        UserInput in = new UserInput();
        while(work) {
            System.out.print(mainMenu);
            mainMenu.executeCommand(in.getNextLine());
        }
        in.closeInput();
    }
}
