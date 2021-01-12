package web;

import dto.BookDTO;
import dto.BookDetailDTO;
import services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {

    private final BookService bookService;

    public HomePageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        List<BookDTO> latestBooks = this.bookService.findLatestAuthorBooks();
        List<BookDTO> suggestedBooks = this.bookService.findSuggestedBooks();
        List<BookDTO> findLatestBookByGenre = this.bookService.findLatestBookByGenre();
        model.addAttribute("latestBooks", latestBooks);
        model.addAttribute("suggestedBooks", suggestedBooks);
        model.addAttribute("findLatestBookByGenre", findLatestBookByGenre);
        return "index";
    }

    @GetMapping("/book/{id}")
    public String findBookById(@PathVariable Long id, Model model) {
        BookDetailDTO bookDetailDTO = this.bookService.findBookById(id);
        model.addAttribute("book", bookDetailDTO);
        return "book";
    }
}
