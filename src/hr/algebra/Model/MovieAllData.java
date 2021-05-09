package hr.algebra.Model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author Marta
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieAllData {

    @XmlElement(name = "movie")
    private Movie movie;
    @XmlElementWrapper
    @XmlElement(name = "actor")
    private List<Person> actors;
    @XmlElementWrapper
    @XmlElement(name = "director")
    private List<Person> directors;
    @XmlElementWrapper
    @XmlElement(name = "directoractor")
    private List<Person> directorActors;
    @XmlElementWrapper
    @XmlElement(name = "genre")
    private List<Genre> genres;

    public MovieAllData() {
    }

    public MovieAllData(Movie movie, List<Person> actors, List<Person> directors, List<Person> directorActors, List<Genre> genres) {
        this.movie = movie;
        this.actors = actors;
        this.directors = directors;
        this.directorActors = directorActors;
        this.genres = genres;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    public List<Person> getDirectorActors() {
        return directorActors;
    }

    public void setDirectorActors(List<Person> directorActors) {
        this.directorActors = directorActors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

}
