import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile("password\\s*:*\\s*(\\p{Alnum}*)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            do {
                System.out.println(matcher.group(1));
            } while (matcher.find());
        } else {
            System.out.println("No passwords found.");
        }
    }
}
