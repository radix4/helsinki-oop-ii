package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MindfulDictionary {
    private Map<String, String> words;
    private String file;

    public MindfulDictionary() {
        words = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this();
        this.file = file;
    }

    public void add(String word, String translation) {
        if (words.containsKey(word)) {
            return;
        }

        words.put(word, translation);
        words.put(translation, word);
    }

    public String translate(String word) {
        return words.get(word);
    }

    public void remove(String word) {
        if (!words.containsKey(word)) {
            return;
        }

        String translation = translate(word);

        words.remove(word);
        words.remove(translation);
    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(new File(file));
            readFileIntoDictionary(reader);
            reader.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void readFileIntoDictionary(Scanner reader) {
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] parts = line.split(":");

            words.put(parts[0], parts[1]);
            words.put(parts[1], parts[0]);
        }
    }

    private void saveWords(FileWriter writer) throws IOException {
        List<String> alreadyInFile = new ArrayList<String>();

        for (String word : words.keySet()) {

            String translation = words.get(word);

            if (!alreadyInFile.contains(word)) {
                String pair = word + ":" + words.get(word);
                writer.write(pair + "\n");
                alreadyInFile.add(translation);
            }
        }
    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(new File(file));
            saveWords(writer);
            writer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
