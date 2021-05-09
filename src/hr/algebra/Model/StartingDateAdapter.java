package hr.algebra.Model;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Marta
 */
public class StartingDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String text) throws Exception {
        return LocalDate.parse(text, Movie.DATE_FORMATTER);
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        return date.format(Movie.DATE_FORMATTER);
    }

}
