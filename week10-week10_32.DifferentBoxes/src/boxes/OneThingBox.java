package boxes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneThingBox extends Box {
    private Thing thing;

    public OneThingBox() {
    }


    @Override
    public void add(Thing thing) {
        if(this.thing == null){
            this.thing = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.thing != null && this.thing.equals(thing);
    }
}
