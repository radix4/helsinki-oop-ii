
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    private File file;

    public List<String> read(String file) throws FileNotFoundException {
        List<String> string = new ArrayList<String>();
        this.file = new File(file);

        Scanner reader = new Scanner(this.file);

        while (reader.hasNextLine()){
            string.add(reader.nextLine());
        }

        return string;

    }

    public void save(String file, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(file); // this creates a new file
        fileWriter.write(text);
        fileWriter.close(); // have to close the file in order to write it
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter fileWriter = new FileWriter(file);// this creates a new file


        for (String line : texts){
            fileWriter.write(line);
            fileWriter.write("\n");
        }


        fileWriter.close(); // have to close the file in order to write it
    }
}
