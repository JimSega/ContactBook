package command;

import contacts.*;

public class ListCommand implements Command {
    private final PhoneBook phoneBook;
    public ListCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    public void execute() {
        phoneBook.list();
        Menu listMenu = Menu.constructMenu("\n[list] Enter action",
                "[number]", "back");
        UserInput in = new UserInput();
        System.out.println(listMenu);
        String command = in.getNextLine();
        if (command.matches("\\d+")) {
            int i = Integer.parseInt(command);
            listMenu.setCommand("[list]", new InfoCommand(phoneBook, i - 1));
            listMenu.executeCommand("[list]");
            phoneBook.info(i - 1);
        }
        else {
            switch (command.toLowerCase()) {
                case "back" -> System.out.println();
                case "menu" -> {
                }
                default -> System.out.println("Unknown command!\n");
            }
        }
    }

}
