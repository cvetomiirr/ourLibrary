package repository;

import domain.Book;
import domain.Read;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasicRepository<T extends Read> extends JpaRepository<T, Long> {

    Book findByTitle(String title);

}
