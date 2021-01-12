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
}
