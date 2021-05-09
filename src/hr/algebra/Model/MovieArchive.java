/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.Model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marta
 */
@XmlRootElement(name = "moviearchive")
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieArchive {

    @XmlElementWrapper
    @XmlElement(name = "moviedata")
    private List<MovieAllData> movies;

    public MovieArchive(List<MovieAllData> movies) {
        this.movies = movies;
    }

    public MovieArchive() {
    }

    public List<MovieAllData> getMovies() {
        return movies;
    }

}
