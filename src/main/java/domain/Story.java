package domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Story extends Read {
    private String summary;

    private String text;

    public Story(String title, Instant year, Language language, Genre genre, String image, float rating, String summary, String text) {
        super(title, year, language, genre, image, rating);
        this.summary = summary;
        this.text = text;
    }


    public Story() {
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Summary: " + this.summary ;
    }


}
