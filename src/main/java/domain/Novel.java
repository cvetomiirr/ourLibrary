package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.Instant;

@Entity
public class Novel extends Book implements BlackAndWhite {

    private boolean isBlackAndWhite;

    @Column(length = 2000)
    private String summary;
    private boolean series;

    public Novel(String title, Instant year, Language language, Genre genre, String image, float rating, Author author, int pages, boolean isBlackAndWhite,boolean series, String summary) {
        super(title, year, language, genre, image, rating, author, pages);
        this.isBlackAndWhite = isBlackAndWhite;
        this.series = series;
        this.summary = summary;

    }

    public Novel() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isSeries() {
        return series;
    }

    public void setSeries(boolean series) {
        this.series = series;
    }

    public void setBlackAndWhite(boolean blackAndWhite) {
        isBlackAndWhite = blackAndWhite;
    }

    @Override
    public boolean isBlackAndWhite() {
        return isBlackAndWhite;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", summary='" + summary + '\'' +
                ", series='" + series + '\'' +
                ", is black and white='" + isBlackAndWhite + '\'' +
                 '\n';
    }

    @Override
    public void print() {
        super.print();
        System.out.println("This novel will be printed black and white");
        System.out.println(toString());
    }
}
