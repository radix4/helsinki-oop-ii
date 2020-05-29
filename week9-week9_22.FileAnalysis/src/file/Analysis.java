package file;

import javafx.animation.ScaleTransition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Analysis {
    private List<String> lines;

    public Analysis(File file) throws Exception{
        this.lines = new ArrayList<String >();
        Scanner readFile = new Scanner(file);

        while (readFile.hasNextLine()){
            lines.add(readFile.nextLine());
        }
    }

    public int lines(){
        return this.lines.size();
    }

    public int characters(){
        String string = "";

        for (String s : this.lines){
            string += s;
        }

        return string.length() + this.lines.size();
    }

}
