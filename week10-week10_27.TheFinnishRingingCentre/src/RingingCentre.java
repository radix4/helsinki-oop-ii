import java.util.*;

public class RingingCentre {
    private Map<Bird, List<String>> observations;

    public RingingCentre() {
        this.observations = new HashMap<Bird, List<String>>();

    }

    public void observe(Bird bird, String place){
        /*List<String> places = this.observations.get(bird);

        if (places == null){
            places = new ArrayList<String>();
        }

        places.add(place);

        this.observations.put(bird, places);*/


        if (this.observations.get(bird) == null){
            this.observations.put(bird,new ArrayList<String>());
        }
        this.observations.get(bird).add(place);
    }

    public void observations(Bird bird){
        if (this.observations.get(bird) == null){
            System.out.println(bird + " observations: " + 0);
        } else {
            List<String> places = this.observations.get(bird);
            int numberOfObservations = places.size();

            System.out.println(bird + " observations: " + numberOfObservations);
            for (String place : places){
                System.out.println(place);
            }

        }
    }
}
