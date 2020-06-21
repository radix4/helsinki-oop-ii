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
}
