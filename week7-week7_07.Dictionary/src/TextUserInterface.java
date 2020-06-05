import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start(){
        System.out.println("Statements:\n" +
                "  add - adds a word pair to the dictionary\n" +
                "  translate - asks a word and prints its translation\n" +
                "  quit - quits the text user interface\n");
        statement();

    }

    public void statement(){
        while (true){
            System.out.print("Statement: ");
            String statement = reader.nextLine();

            if (statement.equals("quit")){
                System.out.println("Cheers!");
                return;
            } else if (statement.equals("add")) {
                addWord();
                System.out.println();
            } else if (statement.equals("translate")) {
               translate();
                System.out.println();
            }else {
                System.out.println("Unknown Statement\n");
            }
        }
    }

    public void addWord(){
        System.out.print("In Finnish: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();

        dictionary.add(word,translation);
    }

    public void translate(){
        System.out.print("Give a word: ");
        String word = reader.nextLine();

        System.out.println("Translation: " + dictionary.translate(word));
    }
}
