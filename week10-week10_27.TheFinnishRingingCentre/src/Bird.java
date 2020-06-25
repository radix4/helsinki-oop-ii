/**
 * This program keeps track of observed birds in a ringing center.
 * @author  Thang Cao
 * @since   06/25/2020
 * */

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
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(this.getClass() == o.getClass())){
            return false;
        }

        Bird compared = (Bird) o;

        return latinName.equals(compared.getLatinName()) && ringingYear == compared.getRingingYear();
    }

    public String getLatinName() {
        return latinName;
    }

    public int getRingingYear() {
        return ringingYear;
    }

    @Override
    public int hashCode() {
       if (latinName == null) {
           return ringingYear;
       }

       return latinName.hashCode() + ringingYear;
    }

    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }

    public static void main(String[] args) {
        RingingCentre kumpulaCentre = new RingingCentre();

        kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2012), "Arabia" );
        kumpulaCentre.observe( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012), "Vallila" );
        kumpulaCentre.observe( new Bird("European Herring Gull", "Larus argentatus", 2008), "Kumpulanmäki" );
        kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2008), "Mannerheimintie" );

        kumpulaCentre.observations( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012 ) );
        System.out.println("--");
        kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 2008 ) );
        System.out.println("--");
        kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 1980 ) );
    }
}


