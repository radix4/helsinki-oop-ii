package reference;

import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Reference {
    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public Film recommendFilm(Person person){
        Map<Film, List<Rating>> filmRatings = ratingRegister.filmRatings();

        /* OR
        List<Film> films = new ArrayList<Film>();
        films.addAll(filmRatings.keySet());
        */

        List<Film> films = new ArrayList<Film>(filmRatings.keySet());

        Collections.sort(films, new FilmComparator(filmRatings));

        return films.get(0);
    }
}
