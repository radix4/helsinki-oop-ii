import java.util.Objects;

public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }

    public String getLatinName() {
        return latinName;
    }

    public int getRingingYear() {
        return ringingYear;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null){
            return false;
        }

        if (!(object instanceof Bird)){
            return false;
        }

        Bird compared = (Bird) object;

        return this.latinName == compared.getLatinName()
                && this.ringingYear == compared.getRingingYear();
    }

    @Override
    public int hashCode() {
        if(this.latinName == null){
            return this.ringingYear;
        }

        return Objects.hash(latinName, ringingYear);

        // or return this.latinName.hashCode() + this.ringingYear;
    }
}


