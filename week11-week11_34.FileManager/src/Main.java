
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();

        List<String> texts = new ArrayList<String>();
        texts.add("One");
        texts.add("Two");

        t.save("src/testinput1.txt", texts);

        for (String s : t.read("src/testinput1.txt")){
            System.out.println(s);
        }
    }
}
