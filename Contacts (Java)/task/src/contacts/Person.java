package contacts;

import java.time.LocalDate;

public class Person extends Contact{

    private String name;
    private String surname;
    private String  gender;
    private String birth;
    Person(String name, String surname, String number, String birthDate, String  gender) {
        this.name = name;
        this.surname = surname;
        super.setNumber(number);
        this.birth = birthDate;
        this.gender = gender;
    }
    public String getFirstName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return surname;
    }

    public void setLastName(String lastName) {
        this.surname = lastName;
    }

    public void setGender(String  gender) {
        if(!gender.matches("[MmFf]")) {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        } else {
            this.gender = gender;
        }

    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birth;
    }

    public void setBirthDate(String birthDate) {
        try {
            LocalDate.parse(birthDate);
            this.birth = birthDate;
        } catch (Exception ex) {
            System.out.println("Bad birth date!");
            this.birth = "[no data]";
        }

    }
    public String toString() {
        return "Name: " + name + "\nSurname: " + surname + "\nBirth date: " + birth + "\nGender: " + gender +
                "\nNumber: " + super.getNumber() + "\nTime created: " + super.getLocalDateTime() + "\nTime last edit: "
                + super.getLocalDateTimeEditLast();
    }

    @Override
    public String getAllField() {
        return "name, surname, birth, gender, number";
    }

    @Override
    public void setField(String field, String volume) {
        switch (field.toLowerCase()) {
            case "name" -> this.setFirstName(volume);
            case "surname" -> this.setLastName(volume);
            case "birth" -> this.setBirthDate(volume);
            case "gender" -> this.setGender(volume);
            case "number" -> super.setNumber(volume);
            default -> System.out.println("Wrong field!");
        }
    }

    @Override
    public String getField(String field) {
        String str = null;
        switch (field.toLowerCase()) {
            case "name" -> str = name;
            case "surname" -> str = surname;
            case "birth" -> str = birth;
            case "gender" -> str = gender;
            case "number" -> str = super.getNumber();
        }
        return str;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String number;
        private String  gender;
        private String birthDate;
        public Builder addFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder addLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder addNumber(String number) {
            this.number = number;
            return this;
        }
        public Builder addGender(String  gender) {
            this.gender = gender;
            return this;
        }
        public Builder addBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }
        public Contact build() {
            return new Person(firstName, lastName, number, birthDate, gender);
        }
    }
}
