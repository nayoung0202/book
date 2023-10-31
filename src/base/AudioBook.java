package base;

import java.time.LocalDate;

public class AudioBook extends Book{
    private String fileSize;
    private String language;
    private int playTime;

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
