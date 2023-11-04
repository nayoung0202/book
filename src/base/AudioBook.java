package base;

import java.time.LocalDate;
import java.util.Objects;

public class AudioBook extends Book{
    private Long fileSize;
    private String language;
    private int playTime;

    public AudioBook(Long id, String name, String author, Long isbn, LocalDate publishedDate,
                     Long fileSize, String language, int playTime ) {
        super (id, name, author, isbn, publishedDate);

        this.fileSize = fileSize;
        this.playTime = playTime;
        this.language = language;
    }
    public AudioBook(String name, String author, Long isbn, LocalDate publishedDate,
                     Long fileSize, String language, int playTime ) {
        super (name, author, isbn, publishedDate);

        this.fileSize = fileSize;
        this.playTime = playTime;
        this.language = language;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public String getLanguage() {
        return language;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getIsbn());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AudioBook){
            AudioBook b = (AudioBook) obj;
            if(this.getName().equals(b.getName()) && this.getAuthor().equals(b.getAuthor()) && this.getIsbn().equals(b.getIsbn())){
                return true;
            }
            return false;
        }
        return false;
    }
}
