package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {

        if (name == null || name.equals("") || name.length() > 40) {
            throw new IllegalArgumentException("Blabla!");
        }

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Blop!");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
