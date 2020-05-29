package people;

public class Person {
    private String name;
    private String street;

    public Person(String name, String street) {
        this.name = name;
        this.street = street;
    }

    @Override
    public String toString() {
        return name + "\n  " + street;
    }
}
