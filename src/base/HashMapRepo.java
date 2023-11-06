package base;

import java.util.*;
import java.util.function.Predicate;

public class HashMapRepo implements BookRepository {
    //hash맵 구현객체니까 해쉬맵으로 생성
    HashMap<Long, Book> bookList = new HashMap<>();

    @Override
    public boolean addBook(Long id, Book book) {
        //hashMap일때 데이터 추가
        //map에 추가하려는 요소가 없다면 추가.
        //아래 두 케이스에 대해서 키:5L 의 값이 들어가지 않음. //조건문이 아래처럼 되어있으면 변경하면 들어는 가는데...
        //이후 동일 키에 다른 데이터를 넣을경우, 중복저장x 갱신됨
        //1L, new Book(1L,"돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331795"), LocalDate.parse("2020-06-15")));
        //5L, new Book(5L,"돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331795"), LocalDate.parse("2021-09-24")));
        if (!bookList.containsValue(book)) {
            bookList.put(id, book);
            return true;
        } else {
            bookList.put(id, book);
            return false;
        }
    }
    @Override
    public Book getBook(Long id) {
        //키값
        return bookList.get(id);
    }

    @Override
    public List<Book> getBooks() {
        //밸류값
        return new ArrayList<>(bookList.values());
    }

    @Override
    public void removeBook(long id) {
        //삭제
        if (bookList.get(id) != null) {
            bookList.remove(id);
            System.out.println("도서 번호 " + id + "의 삭제가 완료되었습니다.");
        } else {
            System.out.println("삭제할 도서 정보가 없습니다. 다시 확인해 주십시오");
        }
    }

    @Override
    public void updateBook(long id, Book book) {
        //BM에서 findbook사용하여 수정하고자 하는 도서 유무를 확인하므로 여기서는 false 필요없음
        if (bookList.containsValue(book)) {
            bookList.replace(id, book);
            System.out.println("도서 번호 " + id + "의 수정이 완료되었습니다.");
        }
    }

    @Override
    public void sameBooks() {
        //스트림으로 재구성하자
        Set<Long> keyset = bookList.keySet();
        Iterator<Long> iterator = keyset.iterator();
        //중복 카운트용
        int count = 0;
        //1.for문을 통해 키값 하나가 키값 전체를 순회하며 조회
        for (Long key : bookList.keySet()) {
            Book bookval = bookList.get(key);
            //반복자를 통해 키값 전체를 순회해 감
            while (iterator.hasNext()) {
                Long itKey = iterator.next();
                Book bookval1 = bookList.get(itKey);
                //for문의 key와 반복자를 통해 지금 조회한 itKey값을 비교
                if (bookval.equals(bookval1) && !(key.equals(itKey))) {
                    if (bookval1.equals(bookval)) {
                        System.out.println("------ 상호 중복 도서(제목,저자,isbn이 같습니다.) ------");
                        System.out.println(bookval.toString());
                        System.out.println(bookval1.toString());
                        count++;
                    }
                }
            }
            //while문을 탈출하면서 반복자 초기화 > 여기서 초기화 시키지 않으면 다음 키에서 while문을 돌때 반복자는 이미 꽉찬상태
            iterator = keyset.iterator();
        }
        System.out.println("중복 개수 : " + count / 2);
    }

}