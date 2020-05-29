package boxes;

import java.util.ArrayList;
import java.util.List;

public class BlackHoleBox extends Box{
    private List<Thing> things;

    public BlackHoleBox() {
        this.things = new ArrayList<Thing>();
    }


    @Override
    public void add(Thing thing) {
        things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
}
