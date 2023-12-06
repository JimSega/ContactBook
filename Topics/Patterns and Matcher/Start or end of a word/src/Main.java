import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        // write your code here
        boolean answer = false;

        for(String str : line.split("[\\s,.!?:]")) {
            Pattern pattern = Pattern.compile(part + "$|^" + part, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(str);
            if(matcher.find()) {
                answer = true;
                break;
            }
        }
        System.out.println(answer  ? "YES" : "NO");
    }
}