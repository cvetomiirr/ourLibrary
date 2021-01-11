package services;

import domain.*;
import dto.BookDTO;
import dto.BookDetailDTO;
import repository.BookRepository;
import repository.ChildBookRepository;
import repository.NovelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService  {
    private final NovelRepository novelRepository;
    private final ChildBookRepository childBookRepository;
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(NovelRepository novelRepository, ChildBookRepository childBookRepository, BookRepository bookRepository, ModelMapper modelMapper) {
        this.novelRepository = novelRepository;
        this.childBookRepository = childBookRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDTO> findLatestAuthorBooks() {
        List<Book> allBooks = this.bookRepository.findAll();
        return allBooks
                .stream()
                .filter(book -> book.equals(book.getAuthor().getLatestBook()))
                .map(book -> this.modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findLatestBookByGenre() {
        List<Book> books = bookRepository.findAll();
        Map<Genre, Book> booksByGenreMap = new HashMap<>();
        for(Book book : books){
            Book existingBook = booksByGenreMap.get(book.getGenre());

            if (existingBook == null) {
                booksByGenreMap.put(book.getGenre(), book);
                continue;
            }

            if(existingBook.getYear().compareTo(book.getYear()) < -1) {
                booksByGenreMap.put(book.getGenre(), book);
            }
        }


        return booksByGenreMap.values()
                .stream()
                .map(book -> this.modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<BookDTO> findSuggestedBooks() {
        List<Book> suggestedBooks = this.bookRepository.findSuggestedBooks();
        return suggestedBooks
                .stream()
                .sorted((b1, b2) -> Float.compare(b2.getRating(), b1.getRating()))
                .map(book -> this.modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDetailDTO findBookById(Long id) {
        Book book = this.bookRepository.findById(id).orElse(null);

        BookDetailDTO bookDetailDTO = this.modelMapper.map(book, BookDetailDTO.class);

        return bookDetailDTO;
    }

    public List<ChildBook> allChildBooks() {
        return this.childBookRepository.findAll();
    }

    public List<Novel> allNovels() {
        return this.novelRepository.findAll();
    }

    public List<Book> findBooksByAuthor(Author author) {
        return this.bookRepository.findAllByAuthor(author);
    }

    public Book findBookByTitle(String title) {
        return this.bookRepository.findByTitle(title);
    }

    public Book findBookByAuthorAndTitle(String title , Author author) {
        return this.bookRepository.findBookByAuthorAndTitle(title,author);
    }

    public Book theLatestBook() {
        Instant latestYear = Instant.now();
        Book latestBook = null;
        List<Book> books = this.bookRepository.findAll();
        for (Book book : books) {
            if (book.getYear().compareTo(latestYear) > 1) {
                latestYear = book.getYear();
                latestBook = book;
            }
        }
        return latestBook;
    }

    public List<Book> findBookByAlias(String alias) {
        return this.bookRepository.findAllByAuthorAlias(alias);
    }

    public List<Book> findBookByPages(int min, int max) {
        return this.bookRepository.findBookByPagesBetween(min,max);
    }

}
