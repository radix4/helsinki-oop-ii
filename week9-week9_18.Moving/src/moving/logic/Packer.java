package moving.logic;

import moving.Thing;
import moving.domain.Box;

import java.util.ArrayList;
import java.util.List;

public class Packer {

    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();

        for (Thing t : things) {
            Box ml = new Box(boxesVolume);
            ml.addThing(t);
            boxes.add(ml);
        }

        return boxes;
    }
}
