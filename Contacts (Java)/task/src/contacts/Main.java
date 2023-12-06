package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("[menu] Enter action (add, list, search, count, exit):");
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        String answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("exit")) {
            Action.action(answer, phoneBook, scanner);
            System.out.println("\n[menu] Enter action (add, list, search, count, exit):");
            answer = scanner.nextLine();
        }
        scanner.close();

    }
}
