import java.util.Scanner;

public class Reader {
    private Scanner reader;

    public Reader() {
        this.reader = new Scanner(System.in);
    }

    public String readString(){
        return reader.nextLine();
    }

    public int readInteger(){
        return Integer.parseInt(readString());
    }
}
