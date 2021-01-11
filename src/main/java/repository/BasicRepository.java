package repository;

import domain.Book;
import domain.Genre;
import domain.Read;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.Instant;
import java.util.List;

@NoRepositoryBean
public interface BasicRepository<T extends Read> extends JpaRepository<T, Long> {

    Book findByTitle(String title);
    List<Book> findAllByYear(Instant year);
    List<Book> findAllByLanguage(String language);
    List<Book> findAllByGenre (Genre genre);

}
