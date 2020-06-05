
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    private Map<String,String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<String, String>();
    }

    public ArrayList<String> translationList(){
        ArrayList<String> translations = new ArrayList<String>();

        for (String key : dictionary.keySet()){
            translations.add(key + " = " + dictionary.get(key));
        }

        return translations;
    }

    public int amountOfWords(){
        return dictionary.size();
    }

    public String translate(String word){
        if (!dictionary.containsKey(word)){
            return null;
        }

        return dictionary.get(word);
    }

    public void add(String word, String translation){
        if (!dictionary.containsKey(word)){
            dictionary.put(word,translation);
        }
    }
}
