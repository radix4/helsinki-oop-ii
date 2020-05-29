import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start(){
        while (true) {
            System.out.print("Statement: ");
            String statement = reader.nextLine();

            if (statement.equals("quit")){
                System.out.println("Cheers!");
                return;
            }

            if (statement.equals("add")){
                add();
            } else if (statement.equals("translate")){
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }

    public void add(){
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
