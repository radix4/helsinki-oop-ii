import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Printer {
    private List<String> lines;

    public Printer(String t) throws Exception {
        Scanner file = new Scanner(new File(t));
        lines = new ArrayList<String>();

        while (file.hasNextLine()) {
            lines.add(file.nextLine());
        }
    }

    public void printLinesWhichContain(String word) {
        for (String line : lines) {
            if (word.isEmpty() || line.contains(word)) {
                System.out.println(line);
            }
        }
    }
}
