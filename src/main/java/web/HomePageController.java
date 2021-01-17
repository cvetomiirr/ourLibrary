package web;

import dto.BookDTO;
import dto.BookDetailDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import repository.BookRepository;
import services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.BookServiceImpl;

import java.util.List;

@RestController
@RequestMapping()
public class HomePageController {

    private final BookService bookService;
    public BookRepository bookRepository;

    public HomePageController(BookServiceImpl bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/suggestedBooks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> findSuggestedBooks() {
        return bookService.findSuggestedBooks();
    }

    @GetMapping(value = "/findLatestBookByGenre", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> findLatestBookByGenre() {
        return bookService.findLatestBookByGenre();
    }

    @GetMapping(value = "/findLatestAuthorBooks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> findLatestAuthorBooks() {
        return bookService.findLatestAuthorBooks();
    }

    @GetMapping(value = "/book/{id}",   produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDetailDTO findBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }
}
