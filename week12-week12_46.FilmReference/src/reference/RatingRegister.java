package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class RatingRegister {

    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, Map<Film, Rating>> personalFilmRatings;


    public RatingRegister() {
        this.filmRatings = new HashMap<Film, List<Rating>>();
        this.personalFilmRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Person person, Film film, Rating rating){

        if(!personalFilmRatings.containsKey(person)){
            personalFilmRatings.put(person, new HashMap<Film, Rating>());
        }

        personalFilmRatings.get(person).put(film,rating);
        addRating(film,rating);
    }

    public Rating getRating(Person person, Film film){
        if(personalFilmRatings.get(person) == null){
            return Rating.NOT_WATCHED;
        }

        if(personalFilmRatings.get(person).get(film) == null){
            return Rating.NOT_WATCHED;
        }

        return personalFilmRatings.get(person).get(film);
    }


    public Map<Film, Rating> getPersonalRatings(Person person){
        if (!personalFilmRatings.containsKey(person)) {
            return new HashMap();
        }

        return personalFilmRatings.get(person);
    }


    public List<Person> reviewers(){
        List<Person> reviewers = new ArrayList<Person>();

        for(Person p : personalFilmRatings.keySet()){
            reviewers.add(p);
        }

        return reviewers;
    }


    public void addRating(Film film, Rating rating){
        if(!filmRatings.containsKey(film)){
            filmRatings.put(film, new ArrayList<Rating>());
        }

        filmRatings.get(film).add(rating);
    }

    public List<Rating> getRatings(Film film){
        return filmRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings(){
        return filmRatings;
    }
}
