import java.util.Scanner;

/** This program manages an airport, with its planes and flights
 * @author  Thang Cao
 * @since   06/06/2020
 * */
public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport();
        Scanner reader = new Scanner(System.in);
        airport.start(reader);
    }
}
