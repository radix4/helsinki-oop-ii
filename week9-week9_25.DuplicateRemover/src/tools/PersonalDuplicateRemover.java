package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover{
    private Set<String> words;
    private int counter;

    public PersonalDuplicateRemover() {
        this.words = new HashSet<String>();
        this.counter = 0;
    }

    @Override
    public void add(String characterString) {
        if (this.words.contains(characterString)){
            this.counter++;
        } else {
            this.words.add(characterString);
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return counter;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.words;
    }

    @Override
    public void empty() {
        this.words.clear();
        this.counter = 0;
    }
}
