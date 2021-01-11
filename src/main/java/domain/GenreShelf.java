package domain;

import exceptions.BookNotAddedException;

import java.util.List;

public class GenreShelf extends Shelf {
    private Genre genre;

    public GenreShelf(String name, int maxSize, Genre genre) {
        super(name, maxSize);
        this.genre = genre;
    }

    @Override
    public void addBooksToShelf(Book... books) throws BookNotAddedException {
        for (Book book : books) {
            if ((books.length <= super.maxSize && book.getGenre().equals(genre))) {
                super.books.add(book);
            } else {
               throw new BookNotAddedException("The book was not added");
            }
        }
    }

    @Override
    public void addBooksToShelf(List<Book> books) {
        for (Book book : books) {
            if (books.size() <= super.maxSize && book.getGenre().equals(this.genre)) {
                super.books.add(book);
            }
        }
    }
}
