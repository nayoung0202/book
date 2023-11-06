package base;

import java.time.LocalDate;
import java.util.Objects;

public class EBook extends Book {
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof EBook ) {
            EBook b = (EBook) obj;
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

        return Objects.hash(super.hashCode(), fileSize);
    }

    private Long fileSize;

    public EBook(Long  id, String name, String author, Long isbn, LocalDate publishedDate, Long fileSize) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setPublishedDate(publishedDate);
        this.fileSize = fileSize;
    }
    public Long getFileSize() {

        return fileSize;
    }

    public void setFileSize(Long fileSize) {

        this.fileSize = fileSize;
    }

}