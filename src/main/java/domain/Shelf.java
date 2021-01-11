package domain;

import exceptions.BookNotAddedException;

import java.util.ArrayList;
import java.util.List;

public abstract class Shelf implements Printable {
    private String name;
    protected List<Book> books = new ArrayList<>();
    protected int maxSize;

    public Shelf(String name, int maxSize) {
        this.name = name;
        this.maxSize = maxSize;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public abstract void addBooksToShelf(Book... books) throws BookNotAddedException;

    public abstract void addBooksToShelf(List<Book> books);


    public void removeBookFromShelf(Book... books) {
        for (Book book : books) {
            this.books.remove(book);
        }
    }

    public void removeBooksFromShelf(List<Book> books) {
        for (Book book : books) {
            this.books.remove(book);
        }
    }

    public void sortBooksAlphabeticaly() {
        for (int i = 0; i < this.books.size(); i++) {
            for (int j = i + 1; j < this.books.size(); j++) {
                String titleOne = this.books.get(i).getTitle();
                String titleTwo = this.books.get(j).getTitle();
                if (titleOne.compareTo(titleTwo) > 0) {
                    Book tempBook = books.get(j);
                    books.set(j, books.get(i));
                    books.set(i, tempBook);
                }
            }
        }
    }

    public void increase() {
        maxSize *= maxSize;
    }

    @Override
    public void print() {
        System.out.println("The printing has started!");
    }

    @Override
    public String toString() {
        return "Shelf name: " + name
                + '\n'
                + books.toString();
    }

    public boolean contains(Book book) {
        return this.books.contains(book);
    }
}
