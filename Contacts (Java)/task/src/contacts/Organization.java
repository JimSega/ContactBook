package contacts;

public class Organization extends Contact{
    private String name;
    private String address;
    Organization(String name, String address, String number) {
        this.name = name;
        this.address = address;
        super.setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Organization name: " + name + "\nAddress: " + address + "\nNumber: "
                + super.getNumber() + "\nTime created: " + super.getLocalDateTime() + "\nTime last edit: "
                + super.getLocalDateTimeEditLast();
    }

    @Override
    public String getAllField() {
        return "name, address, number";
    }

    @Override
    public void setField(String field, String volume) {
        switch (field.toLowerCase()) {
            case "name" -> this.setName(volume);
            case "address" -> this.setAddress(volume);
            case "number" -> super.setNumber(volume);
            default -> System.out.println("Wrong field!");
        }
    }

    @Override
    public String getField(String field) {
       String str = null;
       switch (field.toLowerCase()) {
           case "name" -> str = name;
           case "address" -> str = address;
           case "number" -> str = super.getNumber();
       }
       return str;
    }

    public static class Builder {
        private String name;
        private String address;
        private String number;

        public Builder addName(String name) {
            this.name = name;
            return this;
        }
        public Builder addAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder addNumber(String number) {
            this.number = number;
            return this;
        }
        public Contact build() {
            return new Organization(name, address, number);
        }
    }
}
