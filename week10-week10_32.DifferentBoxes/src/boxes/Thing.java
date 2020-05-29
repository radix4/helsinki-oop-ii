package boxes;

import java.util.Objects;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) { //constructor with 2 paras
        if (weight < 0){
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) { // 1 para constructor
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Thing thing = (Thing) o;

        return Objects.equals(name, thing.name);
    }

    @Override
    public int hashCode() {
        if (name.isEmpty()){
            return 7;
        }

        return Objects.hash(name);
    }


}
