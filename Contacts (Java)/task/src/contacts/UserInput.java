package contacts;

import java.util.Objects;
import java.util.Scanner;

public class UserInput {

    private final Scanner in = new Scanner(System.in);

    public String getNextLine() {
        String input = in.nextLine();
        return Objects.requireNonNullElse(input, "");
    }
    public void closeInput() {
        in.close();
    }
}
