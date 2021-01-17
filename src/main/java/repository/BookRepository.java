package repository;

import domain.Author;
import domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthorAlias(String alias);

    @Query("SELECT b FROM Book AS b where b.rating >= 4")
    List<Book> findSuggestedBooks();
}
