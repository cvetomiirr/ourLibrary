package domain;

import domain.enums.Genre;
import domain.enums.Language;

import javax.persistence.*;
import java.time.Instant;
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Book implements Comparable {
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

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private int pages;

    private boolean series;

    @Column(length = 2000)
    private String summary;



    public Book(String title, Instant year, Language language, Genre genre, String image, float rating, Author author, int pages,  boolean series, String summary) {
        this.title = title;
        this.year = year;
        this.language = language;
        this.genre = genre;
        this.image = image;
        this.rating = rating;
        this.author = author;
        this.pages = pages;
        this.series = series;
        this.summary = summary;
    }

    public Book() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean getSeries() {
        return series;
    }

    public void setSeries(boolean series) {
        this.series = series;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void print() {
        System.out.println("The printing has started!");
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", language=" + language +
                ", genre=" + genre +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", author=" + author +
                ", pages=" + pages +
                ", series=" + series +
                ", summary='" + summary + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object other) {
        if (other instanceof Book) {
            return -this.getYear().compareTo(((Book) other).getYear());
        }
        return 0;
    }
}
