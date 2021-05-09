package hr.algebra.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Marta
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Genre implements Comparable<Genre> {

    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Genre(int id, String name) {
        this(name);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Genre g) {
        return this.getName().compareTo(g.getName());
    }

    @Override
    public boolean equals(Object obj) {
        Genre g = (Genre) obj;
        return this.toString().equals(g.toString());
    }

}
