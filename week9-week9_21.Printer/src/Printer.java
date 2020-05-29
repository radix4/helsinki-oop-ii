import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Printer {
    private Scanner reader;
    private List<String> lines;

    public Printer(String fileName) throws Exception {
        this.reader = new Scanner(new File(fileName));
        this.lines = new ArrayList<String>();

        while (this.reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
    }

    public void printLinesWhichContain(String word) throws Exception {
        for (String string : this.lines) {
            if (word.isEmpty() || string.contains(word)) {
                System.out.println(string);
            }
        }
    }
}