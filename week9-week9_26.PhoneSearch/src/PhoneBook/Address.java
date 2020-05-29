package PhoneBook;

public class Address {

    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity(){
        return this.city;
    }

    @Override
    public String toString() {
        return getStreet() + " " + getCity();
    }
}

