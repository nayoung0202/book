package base;
import base.Book;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.function.Predicate;

public interface BookRepository {
    //BookRepo 인터페이스생성후 뭘해야하는가????
    // ArrayList와 HashMap 별 구현 객체 만들기 이므로
    //구현 객체는 단 두개만 만들면 됨.
    //BM5를 어떻게바꿀까....?
    boolean addBook(Long id, Book book);
    void printBook();
    Book getBook(Long id);
    List<Book> getBooks();
    void removeBook(long id);
    void updateBook(long id, Book book);
    void sameBooks();
}