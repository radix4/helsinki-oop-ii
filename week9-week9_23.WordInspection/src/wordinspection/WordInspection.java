package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    private File file;
    private List<String> lines;
    private final String vowels = "aeiouyäö";

    public WordInspection(File file) throws Exception{
        this.file = file;
        this.lines = new ArrayList<String>();

        Scanner readFile = new Scanner(this.file,"UTF-8");

        while (readFile.hasNextLine()){
            this.lines.add(readFile.nextLine());
        }
    }

    public int wordCount() throws Exception{
        return this.lines.size();
    }

    public List<String> wordsContainingZ(){
        List<String> words = new ArrayList<String>();

        for (String s : this.lines){
            if (s.contains("z")){
                words.add(s);
            }
        }

        return words;
    }

    public List<String> wordsEndingInL(){
        List<String> words = new ArrayList<String>();

        for (String s : this.lines){
            if (s.substring(s.length() - 1).equals("l")){ // word.endsWith("l") works too
                words.add(s);
            }
        }

        return words;

    }

    public List<String> palindromes(){
        List<String> words = new ArrayList<String>();

        for (String s : this.lines){
            String reverseWord = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                reverseWord += s.charAt(i);
            }

            if (s.equals(reverseWord)) {
                words.add(s);
            }
        }

        return words;
    }


    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsWhichContainAllVowels = new ArrayList<String>();

        for (String word : this.lines) {
            if (containsAllVowels(word)) {
                wordsWhichContainAllVowels.add(word);
            }
        }
        return wordsWhichContainAllVowels;
    }

    private boolean containsAllVowels(String word) {
        for (char vowel : this.vowels.toCharArray()) {
            if (!word.contains("" + vowel)) {
                return false;
            }
        }
        return true;
    }

}
