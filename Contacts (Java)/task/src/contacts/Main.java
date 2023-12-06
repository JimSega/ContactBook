package contacts;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("[menu] Enter action (add, list, search, count, exit):");
        Scanner scanner = new Scanner(System.in);
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

        String answer = scanner.nextLine();
        boolean work = true;
        while (!answer.equalsIgnoreCase("exit") && work) {
            work = Action.action(answer, phoneBook, scanner);
            if(work) {
                System.out.println("\n[menu] Enter action (add, list, search, count, exit):");
                answer = scanner.nextLine();
            }
        }
        scanner.close();
        try {
            SerializableFile.serialize(phoneBook, "contacts.db");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
