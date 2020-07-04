/**
 * This program writes and reads words into/from a file.
 * @author  Thang Cao
 * @since   07/01/2020
 * */

package dictionary;

public class Main {
    public static void main(String[] args) {
        MindfulDictionary dict = new MindfulDictionary();
        dict.add("apina", "monkey");
        dict.add("banaani", "banana");
        dict.add("ohjelmointi", "programming");
        dict.remove("apina");
        dict.remove("banana");

        System.out.println( dict.translate("apina") );
        System.out.println( dict.translate("monkey") );
        System.out.println( dict.translate("banana") );
        System.out.println( dict.translate("banaani") );
        System.out.println( dict.translate("ohjelmointi") );
    }
}
