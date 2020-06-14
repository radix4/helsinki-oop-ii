import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tournament {

    private String name;
    private List<Jumper> jumpers;
    private List<JumpRound> rounds;

    public Tournament(String name) {
        this.name = name;
        this.jumpers = new ArrayList<Jumper>();
        this.rounds = new ArrayList<JumpRound>();
    }

    public void addJumper(Jumper jumper) {
        if (this.jumpers.contains(jumper)) {
            return;
        }

        this.jumpers.add(jumper);
    }

    public JumpRound createNextJumpRound() {
        List<Jumper> jumpOrderOfTheRound = new ArrayList(getJumpers());
        Collections.sort(jumpOrderOfTheRound);

        JumpRound round = new JumpRound(this.rounds.size() + 1, jumpOrderOfTheRound);
        this.rounds.add(round);

        return round;
    }

    public List<Jumper> getJumpers() {
        return jumpers;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}