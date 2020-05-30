/** This program prints given String parameter surrounded by smileys
 * @author Thang Cao
 * @date 05/30/2020
 * */

public class Smileys {
    public static void main(String[] args){
        printWithSmileys("1");
        printWithSmileys("12");
    }

    private static void printWithSmileys(String characterString) {
        String middleString = createTheStringInTheMiddle(characterString);
        int number = middleString.length()/2 + 2;

        printSmileys(number);
        System.out.println(":) " + middleString + " :)");
        printSmileys(number);
    }

    private static String createTheStringInTheMiddle(String characterString) {
        if(characterString.length() % 2 == 0){
            return characterString;
        }

        return characterString + " ";
    }

    private static void printSmileys(int number) {
        for (int i = 0; i <= number; i++){
            System.out.print(":)");
        }
        System.out.println();
    }

}