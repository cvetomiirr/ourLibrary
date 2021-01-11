package domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@MappedSuperclass
public abstract class Read implements Printable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private Instant year;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String image;

    private float rating;


    public Read(String title, Instant year, Language language, Genre genre, String image, float rating) {
        this.title = title;
        this.year = year;
        this.language = language;
        this.genre = genre;
        this.image = image;
        this.rating = rating;
    }

    public Read() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getYear() {
        return year;
    }

    public void setYear(Instant year) {
        this.year = year;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "  title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", rating='" + rating + '\'';

    }

    @Override
    public void print() {
        System.out.println("The printing has started!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Read)) return false;
        Read read = (Read) o;
        return getId() == read.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
