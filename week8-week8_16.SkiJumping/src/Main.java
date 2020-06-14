import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Tournament tournament = new Tournament("Ski jumping week!");

        new UserInterface(reader, tournament).start();
    }
}
