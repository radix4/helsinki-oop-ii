import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner reader;
    private Tournament tournament;

    public UserInterface(Scanner reader, Tournament tournament) {
        this.reader = reader;
        this.tournament = tournament;
    }

    public void start() {
        System.out.println(this.tournament.getName());
        System.out.println("");
        createParticipants();

        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");

        jumpRounds();

        System.out.println("");
        System.out.println("Thanks!");
        System.out.println("");

        printFinalResults();
    }

    private void createParticipants() {
        System.out.println("Write the names of the participants one at a time; " +
                "an empty string brings you to the jumping phase.");

        while (true) {
            System.out.print("  Participant name: ");
            String nameOfTheParticipant = this.reader.nextLine();
            if (nameOfTheParticipant.equals("")) {
                break;
            }

            this.tournament.addJumper(new Jumper(nameOfTheParticipant));
        }
    }

    private void jumpRounds() {
        int roundNumber = 1;

        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit:");
            String input = reader.nextLine();
            if (!input.equals("jump")) {
                break;
            }

            System.out.println("");
            System.out.println("Round " + roundNumber);
            System.out.println("");

            jumpRound();
            roundNumber++;

            System.out.println("");
        }
    }

    private void jumpRound() {
        JumpRound round = this.tournament.createNextJumpRound();
        printJumpOrder(round);
        System.out.println("");

        round.jump();
        printRoundResults(round);
    }

    private void printJumpOrder(JumpRound round) {
        System.out.println("Jumping order: ");
        List<Jumper> jumpers = round.getJumpOrder();
        for (int i = 0; i < jumpers.size(); i++) {
            Jumper jumper = jumpers.get(i);
            System.out.println("  " + (i + 1) + ". " + jumper);
        }
    }

    private void printRoundResults(JumpRound round) {
        System.out.println("Results of round " + round.getRoundNumber());
        for (Jumper jumper : round.getJumpOrder()) {
            System.out.println("  " + jumper.getName());
            System.out.println(round.getJump(jumper));
        }
    }

    private void printFinalResults() {
        System.out.println("Tournament results:");
        System.out.println("Position    Name");

        List<Jumper> jumpers = this.tournament.getJumpers();
        Collections.sort(jumpers);
        Collections.reverse(jumpers);

        for (int i = 0; i < jumpers.size(); i++) {
            Jumper jumper = jumpers.get(i);
            System.out.println((i + 1) + "           " + jumper);

            printJumpsOfTheJumper(jumper);
        }
    }

    private void printJumpsOfTheJumper(Jumper jumper) {
        String string = "            jump lengths: ";

        List<Jump> jumps = jumper.getJumps();
        for (int i = 0; i < jumps.size(); i++) {
            Jump hyppy = jumps.get(i);

            string += hyppy.getLength() + " m";
            if (i < jumps.size() - 1) {
                string += ", ";
            }
        }

        System.out.println(string);
    }
}