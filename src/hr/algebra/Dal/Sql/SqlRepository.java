
package hr.algebra.Dal.Sql;

import hr.algebra.Dal.Repository;
import hr.algebra.Model.Genre;
import hr.algebra.Model.Movie;
import hr.algebra.Model.MovieAllData;
import hr.algebra.Model.Person;
import hr.algebra.Model.PersonFunction;
import hr.algebra.Model.User;
import hr.algebra.Model.UserRole;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class SqlRepository implements Repository {

    private static final String ID_GENRE = "IDGenre";
    private static final String NAME = "Name";
    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String DESCRIPTION = "Description";
    private static final String DURATION = "Duration";
    private static final String STARTING_DATE = "StartingDate";
    private static final String LINK = "Link";
    private static final String PICTURE_PATH = "PicturePath";
    private static final String ID_MOVIE_GENRE = "IDMovieGenre";
    private static final String MOVIE_ID = "MovieID";
    private static final String GENRE_ID = "GenreID";
    private static final String ID_MOVIE_PERSON = "IDMoviePerson";
    private static final String ID_PERSON = "IDPerson";
    private static final String SURNAME = "Surname";
    private static final String PERSON_FUNCTION_ID = "PersonFunctionID";
    private static final String ID_USER = "IDUser";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String USER_ROLE_ID = "UserRoleID";

    private static final String GET_USER = "{ CALL getUser (?,?) }";
    private static final String GET_USERS = "{ CALL getUsers }";
    private static final String GET_USER_BY_ID = "{ CALL getUserById (?) }";
    private static final String CREATE_USER = "{ CALL createUser (?,?,?,?,?) }";
    private static final String CREATE_MOVIE = "{ CALL createMovie (?,?,?,?,?,?,?) }";
    private static final String UPDATE_MOVIE = "{ CALL updateMovie (?,?,?,?,?,?,?) }";
    private static final String DELETE_MOVIE = "{ CALL deleteMovie (?) }";
    private static final String GET_MOVIE = "{ CALL getMovie (?) }";
    private static final String GET_MOVIES = "{ CALL getMovies }";
    private static final String CREATE_GENRE = "{ CALL createGenre (?,?)}";
    private static final String DELETE_GENRE = "{ CALL deleteGenre (?)}";
    private static final String DELETE_MOVIE_GENRE = "{ CALL deleteMovieGenre (?,?)}";
    private static final String DELETE_MOVIE_PERSON = "{ CALL deleteMoviePerson (?,?)}";
    private static final String CREATE_MOVIE_PERSON_PF = "{ CALL createMoviePersonSetPF (?,?,?)}";
    private static final String GET_MOVIE_GENRES = "{ CALL getMovieGenres (?)}";
    private static final String GET_GENRE = "{ CALL getGenre (?) }";
    private static final String GET_GENRES = "{ CALL getGenres }";
    private static final String CREATE_MOVIE_GENRE = "{ CALL createMovieGenre (?,?,?) }";
    private static final String CREATE_PERSON = "{ CALL createPerson (?,?,?,?) }";
    private static final String CHECK_PERSON_EXISTS = "{ CALL checkIfPersonExists (?,?,?,?) }";
    private static final String CHECK_GENRE_EXISTS = "{ CALL checkIfGenreExists (?,?) }";
    private static final String GET_PERSON = "{ CALL getPerson (?) }";
    private static final String DELETE_PERSON = "{ CALL deletePerson (?) }";
    private static final String CREATE_MOVIE_PERSON = "{ CALL createMoviePerson (?,?,?) }";
    private static final String GET_MOVIE_ACTORS = "{ CALL getMovieActors (?) }";
    private static final String GET_ACTORS = "{ CALL getActors }";
    private static final String GET_DIRECTORS = "{ CALL getDirectors }";
    private static final String GET_MOVIE_DIRECTORS = "{ CALL getMovieDirectors (?) }";
    private static final String DELETE_ALL_MOVIES_DATA = "{ CALL deleteAllMoviesData }";

    @Override
    public int createUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_USER)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getUserRole().getUserRoleID());
            stmt.registerOutParameter(5, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(5);
        }
    }

    @Override
    public int createMovie(Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getDescription());
            stmt.setInt(3, movie.getDuration());
            stmt.setString(4, movie.getStartingDate().format(movie.DATE_FORMATTER));
            stmt.setString(5, movie.getLink());
            stmt.setString(6, movie.getPicturePath());
            stmt.registerOutParameter(7, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(7);
        }
    }

    @Override
    public Optional<Movie> getMovie(int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MOVIE)) {

            stmt.setInt(1, movieID);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Movie(
                            rs.getInt(ID_MOVIE),
                            rs.getString(TITLE),
                            rs.getString(DESCRIPTION),
                            rs.getInt(DURATION),
                            LocalDate.parse(rs.getString(STARTING_DATE), Movie.DATE_FORMATTER),
                            rs.getString(LINK),
                            rs.getString(PICTURE_PATH)));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public int createGenre(Genre genre) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_GENRE)) {

            stmt.setString(1, genre.getName());
            stmt.registerOutParameter(2, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(2);
        }
    }

    @Override
    public Optional<Genre> getGenre(int genreID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_GENRE)) {

            stmt.setInt(1, genreID);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Genre(
                            rs.getInt(ID_GENRE),
                            rs.getString(NAME)
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public int createMovieGenre(int genreID, int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE_GENRE)) {

            stmt.setInt(1, genreID);
            stmt.setInt(2, movieID);
            stmt.registerOutParameter(3, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(3);
        }
    }

    @Override
    public int createPerson(Person person) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_PERSON)) {

            stmt.setString(1, person.getName());
            stmt.setString(2, person.getSurname());
            stmt.setInt(3, person.getFunction().getPersonFunctionID());
            stmt.registerOutParameter(4, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(4);
        }
    }

    @Override
    public Optional<Person> getPerson(int personID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PERSON)) {

            stmt.setInt(1, personID);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Person(
                            rs.getInt(ID_PERSON),
                            rs.getString(NAME),
                            rs.getString(SURNAME),
                            PersonFunction.getPersonFunctionById(rs.getInt(PERSON_FUNCTION_ID))));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void deletePerson(int personID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_PERSON)) {

            stmt.setInt(1, personID);

            stmt.executeUpdate();
        }
    }

    @Override
    public int createMoviePerson(int personID, int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE_PERSON)) {

            stmt.setInt(1, personID);
            stmt.setInt(2, movieID);
            stmt.registerOutParameter(3, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(3);
        }
    }

    @Override
    public void deleteAllMoviesData() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ALL_MOVIES_DATA)) {
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<User> getUserByID(int userID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_USER_BY_ID)) {

            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(ID_USER),
                            rs.getString(NAME),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            UserRole.getUserRoleById(rs.getInt(USER_ROLE_ID))));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getUser(String username, String password) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_USER)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(ID_USER),
                            rs.getString(NAME),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            UserRole.getUserRoleById(rs.getInt(USER_ROLE_ID))));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> getUsers() throws Exception {
        List<User> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_USERS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt(ID_USER),
                        rs.getString(NAME),
                        rs.getString(USERNAME),
                        rs.getString(PASSWORD),
                        UserRole.getUserRoleById(rs.getInt(USER_ROLE_ID))));
            }
        }
        return users;
    }

    @Override
    public void createMovies(List<MovieAllData> movies) throws Exception {

        for (MovieAllData movieData : movies) {

            int movieId = createMovie(movieData.getMovie());

            List<Person> actors = movieData.getActors();
            if (actors != null) {
                for (Person actor : actors) {

                    int personId = checkPersonExists(actor);

                    if (personId != -1) {

                        createMoviePerson(personId, movieId);

                    } else {
                        personId = createPerson(actor);
                        createMoviePerson(personId, movieId);
                    }
                }
            }

            List<Person> directors = movieData.getDirectors();
            if (directors != null) {
                for (Person director : directors) {

                    int personId = checkPersonExists(director);

                    if (personId != -1) {

                        createMoviePerson(personId, movieId);

                    } else {
                        personId = createPerson(director);
                        createMoviePerson(personId, movieId);
                    }
                }

            }
            List<Person> acDirector = movieData.getDirectorActors();
            if (acDirector.size() != 0) {
                for (Person acD : acDirector) {

                    int personId = checkPersonExists(acD);

                    if (personId != -1) {

                        createMoviePerson(personId, movieId);

                    } else {
                        personId = createPerson(acD);
                        createMoviePerson(personId, movieId);
                    }
                }
            }

            List<Genre> movieGenres = movieData.getGenres();
            if (movieGenres != null) {
                for (Genre movieGenre : movieGenres) {
                    int genreId = checkGenreExists(movieGenre);

                    if (genreId != -1) {

                        createMovieGenre(genreId, movieId);

                    } else {
                        genreId = createGenre(movieGenre);
                        createMovieGenre(genreId, movieId);
                    }
                }
            }

        }
    }

    @Override
    public int checkPersonExists(Person person) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CHECK_PERSON_EXISTS)) {

            stmt.setString(1, person.getName());
            stmt.setString(2, person.getSurname());
            stmt.setInt(3, person.getFunction().getPersonFunctionID());
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.executeUpdate();

            return stmt.getInt(4);
        }
    }

    @Override
    public int checkGenreExists(Genre genre) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CHECK_GENRE_EXISTS)) {

            stmt.setString(1, genre.getName());
            stmt.registerOutParameter(2, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(2);
        }
    }

    @Override
    public List<Movie> getMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MOVIES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                movies.add(new Movie(
                        rs.getInt(ID_MOVIE),
                        rs.getString(TITLE),
                        rs.getString(DESCRIPTION),
                        rs.getInt(DURATION),
                        LocalDate.parse(rs.getString(STARTING_DATE), Movie.DATE_FORMATTER),
                        rs.getString(LINK),
                        rs.getString(PICTURE_PATH)));
            }
        }
        return movies;
    }

    @Override
    public void updateMovie(int movieId, Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_MOVIE)) {

            stmt.setInt(1, movieId);
            stmt.setString(2, movie.getTitle());
            stmt.setString(3, movie.getDescription());
            stmt.setInt(4, movie.getDuration());
            stmt.setString(5, movie.getStartingDate().format(movie.DATE_FORMATTER));
            stmt.setString(6, movie.getLink());
            stmt.setString(7, movie.getPicturePath());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteMovie(int movieId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE)) {

            stmt.setInt(1, movieId);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Person> getActors() throws Exception {
        List<Person> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ACTORS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                actors.add(new Person(
                        rs.getInt(ID_PERSON),
                        rs.getString(NAME),
                        rs.getString(SURNAME),
                        PersonFunction.getPersonFunctionById(rs.getInt(PERSON_FUNCTION_ID))));
            }
        }
        return actors;
    }

    @Override
    public List<Person> getMovieActors(int movieId) throws Exception {
        List<Person> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(GET_MOVIE_ACTORS);
        stmt.setInt(1, movieId);
        try (ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                actors.add(new Person(
                        rs.getInt(ID_PERSON),
                        rs.getString(NAME),
                        rs.getString(SURNAME),
                        PersonFunction.getPersonFunctionById(rs.getInt(PERSON_FUNCTION_ID))));
            }
        }
        return actors;
    }

    @Override
    public List<Person> getDirectors() throws Exception {
        List<Person> directors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DIRECTORS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                directors.add(new Person(
                        rs.getInt(ID_PERSON),
                        rs.getString(NAME),
                        rs.getString(SURNAME),
                        PersonFunction.getPersonFunctionById(rs.getInt(PERSON_FUNCTION_ID))));
            }
        }
        return directors;
    }

    @Override
    public List<Person> getMovieDirectors(int movieId) throws Exception {
        List<Person> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(GET_MOVIE_DIRECTORS);
        stmt.setInt(1, movieId);
        try (ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                actors.add(new Person(
                        rs.getInt(ID_PERSON),
                        rs.getString(NAME),
                        rs.getString(SURNAME),
                        PersonFunction.getPersonFunctionById(rs.getInt(PERSON_FUNCTION_ID))));
            }
        }
        return actors;
    }

    @Override
    public List<Genre> getGenres() throws Exception {
        List<Genre> genres = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(GET_GENRES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                genres.add(new Genre(
                        rs.getInt(ID_GENRE),
                        rs.getString(NAME)
                ));
            }
        }
        return genres;
    }

    @Override
    public List<Genre> getMovieGenres(int movieId) throws Exception {
        List<Genre> genres = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(GET_MOVIE_GENRES);
        stmt.setInt(1, movieId);
        try (ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                genres.add(new Genre(
                        rs.getInt(ID_GENRE),
                        rs.getString(NAME)
                ));
            }
        }
        return genres;
    }

    @Override
    public void deleteGenre(int genreId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_GENRE)) {

            stmt.setInt(1, genreId);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteMoviePerson(int movieId, int personId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE_PERSON)) {

            stmt.setInt(1, movieId);
            stmt.setInt(2, personId);

            stmt.executeUpdate();
        }

    }

    @Override
    public void deleteMovieGenre(int movieId, int genreId) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE_GENRE)) {

            stmt.setInt(1, movieId);
            stmt.setInt(2, genreId);

            stmt.executeUpdate();
        }

    }

    @Override
    public void createMoviePersonSetPF(int personId, int movieId, int personFunction) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE_PERSON_PF)) {

            stmt.setInt(1, personId);
            stmt.setInt(2, movieId);
            stmt.setInt(3, personFunction);

            stmt.executeUpdate();
        }
    }

}
