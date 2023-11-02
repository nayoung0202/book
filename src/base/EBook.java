package base;

import java.time.LocalDate;

public class EBook extends Book {
    private Long fileSize;

    public EBook(Long id, String name, String author, Long isbn, LocalDate publishedDate, Long fileSize) {
        super (id, name, author, isbn, publishedDate);

        this.fileSize = fileSize;
    }
    public EBook(String name, String author, Long isbn, LocalDate publishedDate, Long fileSize) {
        super (name, author, isbn, publishedDate);

        this.fileSize = fileSize;
    }
    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

}

