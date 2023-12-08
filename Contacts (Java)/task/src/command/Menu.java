package command;

import java.util.LinkedHashMap;
import java.util.Map;
import contacts.UserInput;

class Menu {

    private String menuTitle;
    private LinkedHashMap<String, Command> menuItems;

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
        this.menuItems = new LinkedHashMap<>();
    }

    public void setCommand (String name, Command command) {
        menuItems.put(name, command);
    }

    public void executeCommand(String name) {
        if (menuItems.containsKey(name)) {
            menuItems.get(name).execute();
        }
        else System.out.println("Unknown command!\n");
    }

    public String toString() {
        StringBuilder out = new StringBuilder(menuTitle + " (");
        for (Map.Entry<String, Command> item : menuItems.entrySet()) {
            out.append(item.getKey())
                    .append(", ");
        }
        out.deleteCharAt(out.length() - 1).setCharAt(out.lastIndexOf(","),')');
        return out.append(": ").toString();
    }

    public Menu add(String name, Command command) {
        menuItems.putIfAbsent(name, command);
        return this;
    }

    public String getCommandFromUser(String menu, UserInput in) {
        System.out.print(menu);
        return in.getNextLine();
    }

    public static Menu constructMenu(String title, String... commands) {
        Menu menu = new Menu(title);
        for (String string : commands) {
            menu.add(string, null);
        }
        return menu;
    }

}
