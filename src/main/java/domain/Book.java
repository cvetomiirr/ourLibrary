package domain;

import javax.persistence.*;
import java.time.Instant;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "book_type")
@Entity
public abstract class Book extends Read implements Comparable {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private int pages;

    public Book(String title, Instant year, Language language, Genre genre, String image, float rating, Author author, int pages) {
        super(title, year, language, genre, image, rating);
        this.author = author;
        this.pages = pages;
    }

    public Book() {
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


    @Override
    public String toString() {
        return super.toString() +
                ", author='" + author.getShortInfo() + '\'' +
                ", pages=" + pages;
    }

    @Override
    public int compareTo(Object other) {
        if (other instanceof Book) {
            return -this.getYear().compareTo(((Book) other).getYear());
        }
        return 0;
    }

    @Override
    public boolean equals(Object title) {
        return super.equals(title);
    }
}
