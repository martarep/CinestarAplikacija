package hr.algebra.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Marta
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie implements Comparable<Movie> {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "duration")
    private int duration;
    @XmlJavaTypeAdapter(StartingDateAdapter.class)
    @XmlElement(name = "startingdate")
    private LocalDate startingDate;
    @XmlElement(name = "link")
    private String link;
    @XmlElement(name = "picturepath")
    private String picturePath;

    public Movie() {
    }

    public Movie(String title, String description, int duration, LocalDate startingDate, String link, String picturePath) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.startingDate = startingDate;
        this.link = link;
        this.picturePath = picturePath;

    }

    public Movie(int id, String title, String description, int duration, LocalDate startingDate, String link, String picturePath) {
        this(title, description, duration, startingDate, link, picturePath);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Movie m) {
        return this.getTitle().compareTo(m.getTitle());
    }

}
