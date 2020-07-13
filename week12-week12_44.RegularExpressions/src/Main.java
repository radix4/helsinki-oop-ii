/**
 * This program demonstrates regular expressions in Java.
 * @author  Thang Cao
 * @since   07/12/2020
 * */

public class Main {

    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }

    public static void main(String[] args) {
        // write test code here
    }
}
