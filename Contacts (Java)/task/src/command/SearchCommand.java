package command;

import contacts.PhoneBook;

class SearchCommand implements Command {
    private PhoneBook phoneBook;
    public SearchCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    public void execute() {
        this.phoneBook.search(askForQuery(phoneBook.getIn()));
    }

    public String askForQuery(StandardInputHandler in) {
        System.out.print("Enter search query: ");
        return in.getNextLine();
    }
}