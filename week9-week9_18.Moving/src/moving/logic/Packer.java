package moving.logic;

import moving.domain.Box;
import moving.domain.Item;
import moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

public class Packer {
    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> box = new ArrayList<Box>();
        int i = 0;
        for (Thing thing : things) {
            if (box.add(new Box(this.boxesVolume))) {
                box.get(i).addThing(thing);
                i++;
            }
        }
        return box;
    }
}
