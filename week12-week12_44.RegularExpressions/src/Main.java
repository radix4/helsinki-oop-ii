/**
 * This program demonstrates regular expressions in Java.
 * @author  Thang Cao
 * @since   07/12/2020
 * */

public class Main {

    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }

    public static boolean allVowels(String string) {
        return string.matches("[aeiouåäö]*");
    }

    public static boolean clockTime(String string) {
        return string.matches("([01][0123456789]|2[0123]):[012345][0123456789]:[012345][0123456789]");
    }

    public static void main(String[] args) {
        // write test code here
    }
}
