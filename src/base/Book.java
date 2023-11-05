package base;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Book {
    private Long id;
    private String name;
    private String author;
    private Long isbn;
    private LocalDate publishedDate;

    public Book(Long id, String name, String author, Long isbn, LocalDate publishedDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, isbn);
    }

    @Override
    public boolean equals(Object obj) {
        Book b = (Book) obj;
        if (this.name.equals(b.name) && this.author.equals(b.author) && this.isbn.equals(b.isbn)) {
            return true;
        }
    return false;
    }

    public String toString() {
        String toStr = "";
        toStr += "[" + this.id +  "," + this.name + "," + this.author + "," + this.isbn + "," + this.publishedDate;
        if (this instanceof EBook) {
            toStr += ", " + ((EBook)this).getFileSize() + "mb";
        } else if(this instanceof AudioBook){
            toStr += ", " + ((AudioBook)this).getFileSize() + "mb, " + ((AudioBook)this).getLanguage() + ", " +((AudioBook)this).getPlayTime() + "초";
        }
        toStr += "]";
        return toStr;
        }
}


