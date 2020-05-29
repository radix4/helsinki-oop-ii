package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt

        WordInspection object =  new WordInspection(file);

        System.out.println(object.wordCount());

        System.out.println(object.wordsContainingZ());
        System.out.println(object.wordsEndingInL());
        System.out.println(object.wordsWhichContainAllVowels());

    }
}
