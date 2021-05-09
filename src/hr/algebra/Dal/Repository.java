package hr.algebra.Dal;

import hr.algebra.Model.Genre;
import hr.algebra.Model.Movie;
import hr.algebra.Model.MovieAllData;
import hr.algebra.Model.Person;
import hr.algebra.Model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Marta
 */
public interface Repository {

    Optional<User> getUserByID(int userID) throws Exception;

    Optional<User> getUser(String username, String password) throws Exception;

    List<User> getUsers() throws Exception;

    int createUser(User user) throws Exception;

    int createMovie(Movie movie) throws Exception;

    Optional<Movie> getMovie(int movieID) throws Exception;

    int createGenre(Genre genre) throws Exception;

    Optional<Genre> getGenre(int genreID) throws Exception;

    int createMovieGenre(int genreID, int movieID) throws Exception;

    int createPerson(Person person) throws Exception;

    int checkPersonExists(Person person) throws Exception;

    int checkGenreExists(Genre genre) throws Exception;

    Optional<Person> getPerson(int personID) throws Exception;

    void deletePerson(int personID) throws Exception;

    int createMoviePerson(int personID, int movieID) throws Exception;

    void deleteAllMoviesData() throws Exception;

    public void createMovies(List<MovieAllData> movies) throws Exception;

    public List<Movie> getMovies() throws Exception;

    public void updateMovie(int movieId, Movie movie) throws Exception;

    public void deleteMovie(int movieId) throws Exception;

    public List<Person> getActors() throws Exception;

    public List<Person> getMovieActors(int movieId) throws Exception;

    public List<Person> getDirectors() throws Exception;

    public List<Person> getMovieDirectors(int movieId) throws Exception;

    public List<Genre> getGenres() throws Exception;

    public List<Genre> getMovieGenres(int movieId) throws Exception;

    void deleteGenre(int genreId) throws Exception;

    void deleteMoviePerson(int movieId, int personId) throws Exception;

    void deleteMovieGenre(int movieId, int genreId) throws Exception;

    void createMoviePersonSetPF(int personId, int movieId, int personFunction) throws Exception;

}
