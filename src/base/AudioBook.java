package base;

import java.time.LocalDate;
import java.util.Objects;

public class AudioBook extends Book{
    private String fileSize;
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
                     String fileSize, String language, int playTime ) {
        super (id, name, author, isbn, publishedDate);

        this.fileSize = fileSize;
        this.playTime = playTime;
        this.language = language;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getLanguage() {
        return language;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }
}
