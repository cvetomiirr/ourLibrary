package repository;

import domain.Author;
import domain.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
