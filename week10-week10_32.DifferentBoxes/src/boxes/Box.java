package boxes;

import java.util.Collection;

public abstract class Box {


    public void add(Collection<Thing> things) {
        for (Thing thing : things) {
            add(thing);
        }
    }

    public abstract void add(Thing thing);

    public abstract boolean isInTheBox(Thing thing);
}
