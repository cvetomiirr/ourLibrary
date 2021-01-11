package domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Arrays;

@Entity
public class ChildBook extends Book implements Colorable {

    private String[] pictures;
    private int recommendAge;
    private String[] puzzles;
    private boolean isColorable;

    public ChildBook(String title, Instant year, Language language, Genre genre, String image, float rating, Author author, int pages, String[] pictures, int recommendAge, String[] puzzles) {
        super(title, year, language, genre, image, rating, author, pages);
        this.pictures = pictures;
        this.recommendAge = recommendAge;
        this.puzzles = puzzles;
    }

    public ChildBook(String title, Instant year, Language language, Genre genre, String image, float rating, Author author, int pages, String[] pictures, int recommendAge, String[] puzzles, boolean isColorable) {
        this(title, year, language, genre, image, rating , author, pages, pictures, recommendAge,puzzles);
        this.isColorable = isColorable;
    }

    public ChildBook() {
    }

    public boolean isColorable() {
        return this.isColorable;
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    public int getRecommendAge() {
        return recommendAge;
    }

    public void setRecommendAge(int recommendAge) {
        this.recommendAge = recommendAge;
    }

    public String[] getPuzzles() {
        return puzzles;
    }

    public void setPuzzles(String[] puzzles) {
        this.puzzles = puzzles;
    }

    public void setColorable(boolean colorable) {
        isColorable = colorable;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", pictures=" + Arrays.toString(pictures) + '\'' +
                ", recommendAge=" + recommendAge + '\'' +
                ", puzzles=" + Arrays.toString(puzzles) + '\''+
                ", isColorable=" + isColorable +'\'' +
                '\n' ;
    }
}

