package repository;

import domain.Novel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NovelRepository extends BasicBookRepository<Novel> {

    List<Novel> findAllBySeries(boolean series);
    List<Novel> findBySummary(String summary);
    //List<Novel> findAllByisBlackAndWhite(boolean isBlackAndWhite);
}
