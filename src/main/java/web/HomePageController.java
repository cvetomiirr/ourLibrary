package web;

import dto.BookDTO;
import dto.BookDetailDTO;
import dto.StoryDTO;
import dto.StoryDetailDTO;
import services.BookService;
import services.StoryService;
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
    private final StoryService storyService;

    public HomePageController(BookService bookService, StoryService storyService) {
        this.bookService = bookService;
        this.storyService = storyService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        List<BookDTO> latestBooks = this.bookService.findLatestAuthorBooks();
        List<BookDTO> suggestedBooks = this.bookService.findSuggestedBooks();
        List<StoryDTO> allStories = this.storyService.allStories();
        List<BookDTO> findLatestBookByGenre = this.bookService.findLatestBookByGenre();
        model.addAttribute("latestBooks", latestBooks);
        model.addAttribute("suggestedBooks", suggestedBooks);
        model.addAttribute("allStories", allStories);
        model.addAttribute("findLatestBookByGenre", findLatestBookByGenre);
        return "index";
    }

    @GetMapping("/book/{id}")
    public String findBookById(@PathVariable Long id, Model model) {
        BookDetailDTO bookDetailDTO = this.bookService.findBookById(id);
        model.addAttribute("book", bookDetailDTO);
        return "book";
    }

    @GetMapping("/story/{id}")
    public String findStoryById(@PathVariable Long id, Model model) {
        StoryDetailDTO storyDetailDTO = this.storyService.findStoryById(id);
        model.addAttribute("story",storyDetailDTO);
        return "story";
    }

}
