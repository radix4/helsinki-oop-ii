package dungeon;

import java.util.Scanner;

public class Dungeon {

    private Game game;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.game = new Game(length, height, vampires, moves, vampiresMove);
    }

    public void run() {

        Scanner reader = new Scanner(System.in);

        while (!game.finished()) {
            System.out.println(game.situation());

            String command = reader.nextLine();

            game.execute(command);
        }

        if (game.didThePlayerWin()) {
            System.out.println("YOU WIN");
        } else {
            System.out.println("YOU LOSE");
        }
    }
}