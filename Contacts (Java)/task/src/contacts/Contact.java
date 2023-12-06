package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact {

    private String number = "";
    protected final LocalDateTime localDateTime;
    protected LocalDateTime localDateTimeEditLast;
    Contact() {
        localDateTime = LocalDateTime.now();
        localDateTimeEditLast = localDateTime;
    }
    public void setLocalDateTimeEditLast(LocalDateTime localDateTimeEditLast) {
        this.localDateTimeEditLast = localDateTimeEditLast;
    }
    public String getLocalDateTimeEditLast() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm").format(localDateTimeEditLast);
    }
    public String getLocalDateTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm").format(localDateTime);
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        if(checkContact(number)) {
            this.number = number;
        } else {
            this.number = "[no number]";
        }
    }
    public boolean hasNumber() {
        return !number.isEmpty();
    }
    private boolean checkContact(String number) {
        boolean wrongNumber = true;
        boolean parentheses = false;
        Pattern pattern = Pattern.compile("\\+?\\(?\\p{Alnum}+\\)?");
        if(number.matches("[- ]")) {
            System.out.println("Wrong number format!");
            return false;
        }
        for(String group : number.split("[- ]")) {
            Matcher matcher = pattern.matcher(group);
            if(group.matches(".*[()].*")) {
                if(parentheses) {
                    wrongNumber = false;
                }
                parentheses = true;
            }
            if(!matcher.matches() || !wrongNumber) {
                wrongNumber = false;
                System.out.println("Wrong number format!");
                break;
            }
            pattern = Pattern.compile("\\(?\\p{Alnum}{2,}\\)?");
        }
        return wrongNumber;
    }
    public abstract String getAllField();
    public abstract void setField(String field, String volume);
    public abstract String getField(String field);
}
