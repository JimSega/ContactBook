package contacts;

import java.util.Scanner;

public class UserInput {

    private final Scanner in = new Scanner(System.in);

    public String getNextLine() {
        String input = in.nextLine();
        if (input != null) {
            return input;
        }
        else return "";
    }
    public void closeInput() {
        in.close();
    }
}
