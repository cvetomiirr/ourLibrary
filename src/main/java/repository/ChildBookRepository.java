package repository;

import domain.ChildBook;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildBookRepository extends BasicBookRepository<ChildBook> {

    List<ChildBook> findAllByRecommendAge(int recommendAge);
    List<ChildBook> findAllByIsColorable(boolean isColorable);

}
