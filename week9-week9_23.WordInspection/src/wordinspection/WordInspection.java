package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    private List<String> file;

    public WordInspection(File file) {
        try {
            this.file = readWords(file);
        } catch (Exception e) {
            this.file = new ArrayList<String>();
        }
    }

    private List<String> readWords(File file) throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> readLines = new ArrayList();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            line = line.trim();

            if (!line.isEmpty()) {
                readLines.add(line);
            }
        }

        return readLines;
    }

    public int wordCount() {
        return this.file.size();
    }

    public List<String> wordsContainingZ() {
        List<String> toBeReturned = new ArrayList<String>();
        for (String word : this.file) {
            if (word.contains("z")) {
                toBeReturned.add(word);
            }
        }

        return toBeReturned;
    }

    public List<String> wordsEndingInL() {
        List<String> toBeReturned = new ArrayList<String>();
        for (String word : this.file) {
            if (word.endsWith("l")) {
                toBeReturned.add(word);
            }
        }

        return toBeReturned;
    }
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }


    public List<String> palindromes() {
        List<String> toBeReturned = new ArrayList<String>();
        for (String word : this.file) {
            if (word.equals(reverse(word))) {
                toBeReturned.add(word);
            }
        }

        return toBeReturned;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> toBeReturned = new ArrayList<String>();
        for (String word : this.file) {
            if (containsAllVowels(word)) {
                toBeReturned.add(word);
            }
        }

        return toBeReturned;
    }

    private boolean containsAllVowels(String word) {
        String vowels = "aeiouyäö";

        for (char vowel: vowels.toCharArray()) {
            if (!word.contains("" + vowel)) {
                return false;
            }
        }
        return true;
    }
}
