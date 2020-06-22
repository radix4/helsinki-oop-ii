package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary{

    private Map<String, Set<String>> dictionary =
            new HashMap<String, Set<String>>();


    @Override
    public void add(String word, String entry) {
        Set<String> translations = dictionary.get(word);
        if (translations == null) {
            translations = new HashSet<String>();
            dictionary.put(word, translations);
        }
        translations.add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        return dictionary.get(word);
    }

    @Override
    public void remove(String word) {
        dictionary.remove(word);
    }
}
