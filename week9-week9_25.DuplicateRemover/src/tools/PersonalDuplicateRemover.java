package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover{
    private Set<String> words;
    private int dupCount;

    public PersonalDuplicateRemover() {
        this.words = new HashSet<>();
        dupCount = 0;
    }

    @Override
    public void add(String characterString) {
        if (words.contains(characterString)){
            dupCount++;
            return;
        }

        words.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return dupCount;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return words;
    }

    @Override
    public void empty() {
        words.clear();
    }
}
