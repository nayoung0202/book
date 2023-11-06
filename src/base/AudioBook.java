package base;

import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.LogManager;

public class AudioBook extends Book{
    private Long fileSize;
    private String language;
    private int playTime;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AudioBook ) {
            AudioBook b = (AudioBook) obj;

            if(this.getName().equals(b.getName()) &&
                    this.getAuthor().equals(b.getAuthor())
                    && this.getIsbn().equals(b.getIsbn())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fileSize, language, playTime);
    }

    public AudioBook(Long id, String name, String author, Long isbn, LocalDate publishedDate,
                     Long fileSize, String language, int playTime ) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setPublishedDate(publishedDate);
        this.fileSize = fileSize;
        this.language = language;
        this.playTime = playTime;
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
}