import people.Person;
import people.Student;
import people.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add( new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki") );

        printDepartment(people);
    }

    public static void printDepartment(List<Person> people) {
        // we print all the people in the department

        if (people == null){
            return;
        }

        for (Person person : people){
            System.out.println(person);
        }
    }
}
