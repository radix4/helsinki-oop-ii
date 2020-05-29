package dictionary;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MindfulDictionary dict = new MindfulDictionary("src/words.txt");


        dict.load();

            // using the dictionary

        dict.save();
    }
}
