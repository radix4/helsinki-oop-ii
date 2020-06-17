package moving.domain;

import moving.Thing;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing{

    private List<Thing> things;

    private int maximumCapacity;
    private int volume;

    public Box(int maximumCapacity) {
        this.things = new ArrayList<>();
        this.maximumCapacity = maximumCapacity;
        volume = 0;
    }

    public boolean addThing(Thing thing) {
        if (volume + thing.getVolume() > maximumCapacity) {
            return false;
        }

        things.add(thing);
        volume += thing.getVolume();

        return true;
    }

    @Override
    public int getVolume() {
        return volume;
    }
}
