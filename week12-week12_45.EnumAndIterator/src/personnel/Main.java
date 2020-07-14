/**
 * This program demonstrates Enum types and Iterator.
 * @author  Thang Cao
 * @since   07/13/2020
 * */

package personnel;

public class Main {

    public static void main(String[] args) {
        Employees university = new Employees();
        university.add(new Person("Matti", Education.D));
        university.add(new Person("Pekka", Education.GRAD));
        university.add(new Person("Arto", Education.D));

        university.print();

        university.fire(Education.GRAD);

        System.out.println("==");

        university.print();
    }
}
