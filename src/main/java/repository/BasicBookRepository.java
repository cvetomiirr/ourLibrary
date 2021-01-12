package repository;

import domain.Author;
import domain.Book;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BasicBookRepository<T extends Book> extends BasicRepository<T> {

    List<Book> findAllByAuthor(Author author);
}
