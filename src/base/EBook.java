package base;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getIsbn());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof EBook){
        EBook b = (EBook) obj;
        if(this.getName().equals(b.getName()) && this.getAuthor().equals(b.getAuthor()) && this.getIsbn().equals(b.getIsbn())){
            return true;
        }
        return false;
    }
        return false;
    }
}

