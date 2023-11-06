package base;

import java.time.LocalDate;
import java.util.Objects;


public class Book {
    private Long id;
    private String name;
    private String author;
    private Long isbn;
    private LocalDate publishedDate;

    @Override
    public boolean equals(Object obj) {
        //instanceof 객체 확인
        if(obj instanceof Book ) {
            Book b = (Book) obj;
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
        return Objects.hash(name, author, isbn);
    }

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

    public String toString(Long key) {
        String All = "";
        All += "도서[" +
                "도서 번호: " + this.id +
                ", 책 제목: '" + this.name + '\'' +
                ", 작가: '" + this.author + '\'' +
                ", isbn : " + this.isbn +
                ", 출판일 : " + this.publishedDate +
                ']';
        if(this instanceof EBook) {
            All += "파일 크기 : " + ((EBook)this).getFileSize() +"초";
        } else if (this instanceof AudioBook) {
            All += "파일 크기 : " + ((AudioBook)this).getFileSize() +"초" + "언어 : " + ((AudioBook)this).getLanguage() + "실행 시간 : " + ((AudioBook)this).getPlayTime() + "초";
        }
        return All;
    }


}