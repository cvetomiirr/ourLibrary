package services;

import dto.BookDTO;
import dto.BookDetailDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> findLatestAuthorBooks();
    List<BookDTO> findSuggestedBooks();
    List<BookDTO> findLatestBookByGenre();
    BookDetailDTO findBookById(Long id);


}
