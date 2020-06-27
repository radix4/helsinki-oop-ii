import people.Person;

/**
 * This program demonstrates inheritance feature.
 * @author  Thang Cao
 * @since   06/27/2020
 * */

public class Main {

    public static void main(String[] args) {
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
        System.out.println(pekka);
        System.out.println(esko);
    }
}
