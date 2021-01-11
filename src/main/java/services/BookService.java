package services;

import domain.Author;
import domain.Book;
import domain.ChildBook;
import domain.Novel;
import dto.BookDTO;
import dto.BookDetailDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> findLatestAuthorBooks();
    List<BookDTO> findSuggestedBooks();
    List<BookDTO> findLatestBookByGenre();

    BookDetailDTO findBookById(Long id);
    List<ChildBook> allChildBooks();
    List<Novel> allNovels();
    Book findBookByTitle(String title);
    Book findBookByAuthorAndTitle(String title , Author author);
    Book theLatestBook();
    List<Book> findBookByAlias(String alias);
    List<Book> findBookByPages(int min, int max);


}
