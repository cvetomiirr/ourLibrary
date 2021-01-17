package services;

import domain.*;
import domain.enums.Genre;
import dto.BookDTO;
import dto.BookDetailDTO;
import repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService  {
    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    public BookServiceImpl( BookRepository bookRepository, ModelMapper modelMapper) {
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

}
