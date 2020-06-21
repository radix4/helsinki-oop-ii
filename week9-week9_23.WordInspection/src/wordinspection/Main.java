/**
 * This program allows for different kinds of analyses on words.
 * @author  Thang Cao
 * @since   06/21/2020
 * */

package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File file = new File("src/shortList.txt");

        WordInspection f = new WordInspection(file);

        System.out.println(f.wordCount());

    }
}
