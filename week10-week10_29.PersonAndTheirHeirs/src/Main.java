import people.Person;
import people.Student;

/**
 * This program demonstrates inheritance feature.
 * @author  Thang Cao
 * @since   06/27/2020
 * */

public class Main {

    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println( olli );
        olli.study();
        System.out.println( olli );
    }
}
