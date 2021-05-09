package hr.algebra.parsers.Rss;

import hr.algebra.Model.Genre;
import hr.algebra.Model.Movie;
import hr.algebra.Model.MovieAllData;
import hr.algebra.Model.Person;
import hr.algebra.Model.PersonFunction;
import hr.algebra.factory.ParserFactory;
import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.jsoup.Jsoup;

/**
 *
 * @author Marta
 */
public class CinestarParser {

    private static final String RSS_URL = "https://www.blitz-cinestar.hr/rss.aspx?najava=1";
    private static final int TIMEOUT = 10000;
    private static final String REQUEST_METHOD = "GET";
    private static final String EXT = ".jpg";
    private static final String DIR = "assets";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    private static final Random RANDOM = new Random();

    private static boolean isDirector = false;

    public static List<MovieAllData> parse() throws IOException, XMLStreamException {
        List<MovieAllData> movieModel = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL, TIMEOUT, REQUEST_METHOD);
        XMLEventReader reader = ParserFactory.createStaxParser(con.getInputStream());

        Optional<TagType> tagType = Optional.empty();
        MovieAllData movie = null;
        StartElement startElement = null;
        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    startElement = event.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    tagType = TagType.from(qName);
                    if (tagType.isPresent() && TagType.ITEM == tagType.get()) {
                        movie = new MovieAllData();
                        movieModel.add(movie);
                        movie.setMovie(new Movie());
                        movie.setActors(new ArrayList<Person>());
                        movie.setDirectors(new ArrayList<Person>());
                        movie.setDirectorActors(new ArrayList<Person>());
                        movie.setGenres(new ArrayList<Genre>());

                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (tagType.isPresent()) {
                        Characters characters = event.asCharacters();
                        String data = characters.getData().trim();

                        switch (tagType.get()) {
                            case TITLE:
                                if (movie != null && !data.isEmpty()) {
                                    movie.getMovie().setTitle(data);
                                }
                                break;
                            case LINK:
                                if (movie != null && !data.isEmpty()) {
                                    movie.getMovie().setLink(data);
                                }
                                break;
                            case DESCRIPTION:
                                if (movie != null && !data.isEmpty()) {
                                    data = Jsoup.parse(data).text();
                                    movie.getMovie().setDescription(data);
                                }
                                break;
                            case PICTURE:
                                if (movie != null && startElement != null) {

                                    handlePicture(movie.getMovie(), data);

                                }

                                break;
                            case ACTORS:
                                if (movie != null && !data.isEmpty()) {

                                    String[] fullNameActors = data.split(",");

                                    for (String fullNameActor : fullNameActors) {
                                        Person actor = new Person();

                                        String[] nameParts = fullNameActor.trim().split(" ");

                                        for (int i = 0; i < nameParts.length; i++) {

                                            if (i == 0) {
                                                actor.setName(nameParts[i]);
                                            } else {
                                                if (actor.getSurname() != null) {
                                                    actor.setSurname(actor.getSurname() + " " + nameParts[i]);
                                                } else {
                                                    actor.setSurname(nameParts[i]);
                                                }

                                            }
                                        }

                                        if (!isDirector(actor, movie)) {
                                            actor.setFunction(PersonFunction.ACTOR);
                                            movie.getActors().add(actor);
                                        } else {
                                            actor.setFunction(PersonFunction.DIRECTORACTOR);
                                            movie.getDirectorActors().add(actor);
                                        }
                                    }

                                }

                                break;
                            case DIRECTOR:
                                if (movie != null && !data.isEmpty()) {

                                    String[] fullNameDirectors = data.split(",");

                                    for (String fullNameDirector : fullNameDirectors) {

                                        Person director = new Person();

                                        String[] nameParts = fullNameDirector.trim().split(" ");

                                        for (int i = 0; i < nameParts.length; i++) {

                                            if (i == 0) {
                                                director.setName(nameParts[i]);
                                            } else {
                                                if (director.getSurname() != null) {
                                                    director.setSurname(director.getSurname() + " " + nameParts[i]);
                                                } else {
                                                    director.setSurname(nameParts[i]);
                                                }

                                            }

                                        }
                                        director.setFunction(PersonFunction.DIRECTOR);
                                        movie.getDirectors().add(director);
                                    }
                                }
                                break;
                            case GENRE:
                                if (movie != null && !data.isEmpty()) {
                                    Genre genre = new Genre();
                                    data.trim();
                                    String[] genreNames = data.split(",");
                                    for (String genr : genreNames) {
                                        genre.setName(genr.trim());
                                        movie.getGenres().add(genre);
                                    }
                                }

                                break;
                            case STARTINGDATE:
                                if (movie != null && !data.isEmpty()) {
                                    data = data + ".";
                                    List<String> dateparts = new ArrayList<String>();
                                    int position = 0;
                                    int start = 0;
                                    int counter = 0;
                                    do {
                                        counter++;
                                        position = data.indexOf(".", start);
                                        if (position >= 0) {

                                            dateparts.add(data.substring(start, position).trim());
                                            start = position + 1;
                                        }
                                    } while (counter != 3);

                                    LocalDate date = LocalDate.of(Integer.parseInt(dateparts.get(2)), Integer.parseInt(dateparts.get(1)), Integer.parseInt(dateparts.get(0)));
                                    movie.getMovie().setStartingDate(date);
                                }
                                break;
                            case DURATION:
                                if (movie != null && !data.isEmpty()) {
                                    movie.getMovie().setDuration(Integer.parseInt(data));
                                }
                                break;
                        }
                    }
                    break;
            }
        }
        return movieModel;
    }

    private static void handlePicture(Movie movie, String pictureUrl) throws IOException {
        pictureUrl = pictureUrl.replaceAll("http", "https");
        String ext = pictureUrl.substring(pictureUrl.lastIndexOf("."));
        if (ext.length() > 4) {
            ext = EXT;
        }
        String pictureName = Math.abs(RANDOM.nextInt()) + ext;
        String localPicturePath = DIR + File.separator + pictureName;

        FileUtils.copyFromUrl(pictureUrl, localPicturePath);
        movie.setPicturePath(localPicturePath);
    }

    private static String filterData(String data) {
        if (data.length() > 12 && !data.isEmpty()) {
            data.substring(9, data.length() - 3);
        } else {
            data = "";
        }
        return data.trim();
    }

    private static boolean isDirector(Person actor, MovieAllData movie) {

        movie.getDirectors().forEach(d -> {
            if (d.getName() == actor.getName() && d.getSurname() == actor.getSurname()) {
                isDirector = true;
            }

        });
        return isDirector;
    }

    private enum TagType {

        ITEM("item"),
        TITLE("orignaziv"),
        LINK("link"),
        DESCRIPTION("description"),
        DURATION("trajanje"),
        DIRECTOR("redatelj"),
        ACTORS("glumci"),
        PICTURE("plakat"),
        STARTINGDATE("pocetak"),
        GENRE("zanr");

        private final String name;

        private TagType(String name) {
            this.name = name;
        }

        private static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        }
    }
}
