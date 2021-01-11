package domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Story extends Read {

    @Transient
    private User user;

    private String summary;

    private String text;

    public Story(String title, Instant year, Language language, Genre genre, String image, float rating,/* User user,*/ String summary, String text) {
        super(title, year, language, genre, image, rating);
      //  this.user = user;
        this.summary = summary;
        this.text = text;
    }


    public Story() {
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Summary: " + this.summary +
                ", " + user.getShortInfo() + '\n' ;
    }


}
