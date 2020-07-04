/**
 * This program writes and reads words into/from a file.
 * @author  Thang Cao
 * @since   07/01/2020
 * */

package dictionary;

public class Main {
    public static void main(String[] args) {
        MindfulDictionary dict = new MindfulDictionary("src/words.txt");
        dict.load();

        System.out.println( dict.translate("apina") );
        System.out.println( dict.translate("ohjelmointi") );
        System.out.println( dict.translate("alla oleva") );
    }
}
