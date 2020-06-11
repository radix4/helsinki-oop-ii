public class Person implements Comparable<Person>{

    private int salary;
    private String name;

    public Person(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return name + " " + salary;
    }


    /** Returns -1 if this person is greater than o person.
     * Returns 1 if less than and returns 0 if equals. */
    @Override
    public int compareTo(Person o) {
        if (salary > o.getSalary()) {
            return -1;
        } else if (salary < o.getSalary()) {
            return 1;
        }

        return 0;
    }
}
