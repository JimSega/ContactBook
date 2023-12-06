import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "[-+]?(0|[1-9]\\d*)[.,]?";
        String regex2 = "[-+]?(0|[1-9]\\d*)[,.](0|\\d*[^0]$)";
        //String regex3 = "^[+-]?(0|[1-9]\\d*)([.,](0|\\d*[1-9]))?$";

        String number = scanner.nextLine();
        System.out.println((number.matches(regex) || number.matches(regex2)) ? "YES" : "NO");
        //System.out.println(number.matches(regex3) ? "YES" : "NO");
    }
}