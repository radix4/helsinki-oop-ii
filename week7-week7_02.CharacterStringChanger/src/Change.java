public class Change{
    private char fromChar;
    private char toChar;

    public Change(char fromChar, char toChar) {
        this.fromChar = fromChar;
        this.toChar = toChar;
    }

    public String change(String word){
        return word.replace(fromChar,toChar);
    }

}