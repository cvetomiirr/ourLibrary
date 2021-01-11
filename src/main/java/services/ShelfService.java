package services;

import domain.Book;
import domain.Shelf;

import java.util.List;
import java.util.stream.Collectors;


public class ShelfService {
    private List<Shelf> shelves;

    public ShelfService(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public List<Shelf> findShelfByName(String shelfName) {
        List<Shelf> shelfByName = this.shelves
                .stream()
                .filter(shelf -> shelfName == shelf.getName())
                .collect(Collectors.toList());

        return shelfByName;
    }

    public void transferBook(Book book, Shelf src, Shelf dest) throws Exception{
        if (src.contains(book)) {
            dest.addBooksToShelf(book);
            src.removeBookFromShelf(book);
        }else{
            throw new Exception("MY FIRST EXCEPTION");
        }

    }

    public void sortAllBooksInAllShelfsAlphabeticaly() {
        this.shelves
                .stream()
                .forEach(shelf -> shelf.sortBooksAlphabeticaly());
    }

    public void addShelf(Shelf shelf) {
        shelves.add(shelf);
    }

    public void deleteShelf(Shelf shelf) {
        shelves.remove(shelf);
    }

    public static void emptyShelf(Shelf shelf) {
            shelf.getBooks().clear();
    }

    @Override
    public String toString() {
        return " Shelves: " +
                "" + shelves;
    }
}

