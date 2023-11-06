package base;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ArrayListRepo implements BookRepository{
    //arrayList구현객체니까 arryaList로 생성
    ArrayList<Book> bookList = new ArrayList<>();
    @Override
    public boolean addBook(Long id, Book book) {
        //hashMap일때 데이터 추가
        //arrayList에 추가하려는 요소가 없다면 추가 있다면 false 아웃 > set으로 교정?
        //id가 다르나 값이 같은 경우, set으로 인덱스(id) 및 밸류 값을 넣어줌
        if (!bookList.contains(book)) {
            bookList.add(book);
        } else {
            idCheck(id);
            bookList.set(index, book);
        }
        return true;
    }

    @Override
    public void printBook() {
        for (Book book : bookList) {
            //arrayList 조회
            System.out.println(book.toString());
        }
    }

    @Override
    public Book getBook(Long id) {
        return idCheck(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookList;
    }

    @Override
    public void removeBook(long id) {
        Book check = idCheck(id);
        if(check != null) {
            bookList.remove(check);
            System.out.println("도서 번호 " + id + "의 삭제가 완료되었습니다.");
        } else {
            System.out.println("삭제할 도서 정보가 없습니다. 다시 확인해 주십시오");
        }
    }

    @Override
    public void updateBook(long id, Book book) {
        //BM에서 findbook사용하여 수정하고자 하는 도서 유무를 확인하므로,여기서는 false 필요없음
        if (bookList.contains(book)) {
            bookList.set((int) id, book);
            System.out.println("도서 번호 " + id + "의 수정이 완료되었습니다.");
        }
    }
    @Override
    public void sameBooks() {
        List<Book> sameBooks = bookList;
        //중복 카운트용
        int count =0;
        for (int i = 0; i < sameBooks.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (sameBooks.get(i).equals(sameBooks.get(j))) {
                    count++;
                    System.out.println("------ 상호 중복 도서(제목,저자,isbn이 같습니다.) ------");
                    System.out.println(sameBooks.get(i).toString());
                    System.out.println(sameBooks.get(j).toString());
                }
            }
        }
        System.out.println("중복 개수 : " + count);
    }
    //테스트 해보니 id값 반환이 필요
    //인덱스에 있는 id(hashmap으로 치면 키값)을 찾아 리턴
    //인덱스 id의 키값을 getId를 통해 얻은 뒤, 비교하여 맞을경우 해당하는 키값 반환
    private static int index;
    public Book idCheck(long id) {
        for(int i=0; i<bookList.size(); i++){
            if(bookList.get(i).getId().equals(id)){
                index = i;
                return bookList.get(i);
            }
        } return null;
    }
}
