package personnel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Employees university = new Employees();
        university.add(new Person("Matti", Education.D));
        university.add(new Person("Pekka", Education.GRAD));
        university.add(new Person("Arto", Education.D));

        university.print();


    }

}
