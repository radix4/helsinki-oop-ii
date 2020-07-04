package dictionary;

import java.util.HashMap;
import java.util.Map;

public class MindfulDictionary {
    private Map<String, String> words;

    public MindfulDictionary() {
        words = new HashMap<String, String>();
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
}
