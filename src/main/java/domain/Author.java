package domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;

@Entity
@Table(name = "author")
public class Author {

    private String firstName;
    private String lastName;
    private String alias;
    private Instant year;
    private Nationality nationality;

    @Transient
    private Genre genres;

    @OneToMany(mappedBy = "author")
    private Collection<Book> books;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Author() {
    }

    public Author(String firstName, String lastName, String alias, Instant year, Nationality nationality, Genre genres) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.year = year;
        this.nationality = nationality;
        this.genres = genres;
    }

    public Author(String firstName, String lastName, String alias, Instant year, Nationality nationality, Genre genres, Collection<Book> books) {
        this(firstName, lastName, alias, year, nationality, genres);
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Instant getYear() {
        return year;
    }

    public void setYear(Instant year) {
        this.year = year;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public void setGenres(Genre genres) {
        this.genres = genres;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public Genre getGenres() {
        return genres;
    }

     

    public Book getLatestBook() {
        return this.books
                .stream()
                .sorted(Book::compareTo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return " firstName:" + this.firstName
                + " lastName:" + this.lastName
                + " alias:" + this.alias
                + " year:" + this.year
                + " genres:" + this.genres
                + " books:" + this.books
                + "ID:" + this.id;
    }

    public String getShortInfo() {
        return "First name: " + this.firstName
                + " Last Name:" + this.lastName;
    }

    @Override
    public boolean equals(Object author) {
        return this.id == ((Author) author).getId();
    }

}

