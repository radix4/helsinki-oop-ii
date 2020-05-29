
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    public static boolean clockTime(String string){
        return string.matches("([01][0-9]|2[0-3])(:[0-5][0-9]){2}");
    }

    public static boolean allVowels(String string){
        return string.matches("[aeiouäö]*");
    }

    public static boolean isAWeekDay(String string){

        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
}