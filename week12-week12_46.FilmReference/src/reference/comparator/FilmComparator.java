package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;
    private int averageRating;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
        this.averageRating = 0;
    }



    @Override
    public int compare(Film o1, Film o2) {
        int o1Average = 0;
        int o2Average = 0;

        for(Rating r : ratings.get(o1)){
            o1Average += r.getValue();
        }

        for(Rating r : ratings.get(o2)){
            o2Average += r.getValue();
        }

        o1Average /= ratings.get(o1).size();
        o2Average /= ratings.get(o2).size();

        return o2Average - o1Average; //sort highest to lowest

        //1 - 2 will be lowest to highest
    }
}
