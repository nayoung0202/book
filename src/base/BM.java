package base;
import java.util.ArrayList;
// BookManager를 구현하는 구현 객체
public class BM extends BookManager {
    private ArrayList<Book> bookList = new ArrayList<>();
    @Override
    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("--- 도서 [" + book.getName() + "] 등록이 완료 되었습니다.---");
    }

    @Override
    public void printAllBook() {
        System.out.println("■■■■■■ 도서 목록 조회 ■■■■■■");
        for (Book book : bookList) {
            System.out.print("[");
            System.out.print(book.getId());
            System.out.print(", ");
            System.out.print(book.getName());
            System.out.print(", ");
            System.out.print(book.getAuthor());
            System.out.print(", ");
            System.out.print(book.getIsbn());
            System.out.print(", ");
            System.out.print(book.getPublishedDate());
            System.out.print("]");
            System.out.println();
        }
    }

    @Override
    public void updateBook(Book book) {
        for(int i = 1; i <= bookList.size(); i++){
            if(book.getId() == 1) {
                bookList.set(i-1,book);
                System.out.println("수정한 도서 정보가 반영 되었습니다.");
                break;
            }
            if(book.getId() == i + 1) {
                bookList.set(i,book);
                System.out.println("수정한 도서 정보가 반영 되었습니다.");
                break;
            } else {
                System.out.println("해당 되는 도서가 없습니다.");
            }
        }
    }
    @Override
    public void removeBook(Book book) {
        for(int i = 1; i <= bookList.size(); i++){
            if(book.getId() == 1) {
                bookList.remove(i-1);
                System.out.println("수정한 도서 정보가 반영 되었습니다.");
                break;
            }
            if(book.getId() == i + 1) {
                bookList.remove(i);
                System.out.println("수정한 도서 정보가 반영 되었습니다.");
                break;
            } else {
                System.out.println("해당 되는 도서가 없습니다.");
            }
        }
    }
}