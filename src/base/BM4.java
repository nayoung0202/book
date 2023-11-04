package base;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.*;

public class BM4 extends BookManager {
    private HashMap<Long, Book> bookList = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    @Override
    void init() {
        bookList.put(3L, new Book("부자아빠 가난한아빠", "로버트 키요사키", Long.parseLong("5791144331796"), LocalDate.parse("1999-02-15")));
        bookList.put(20L, new AudioBook("산마처럼 비웃는 것", "미쓰다 신조", Long.parseLong("0211129850369"), LocalDate.parse("2008-01-24"), 7500L, "일본어", 9999));
        bookList.put(2L, new EBook("K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2023-02-20"), 1000L));
        bookList.put(4L, new AudioBook("위기의 역사", "오건영", Long.parseLong("7711123000360"), LocalDate.parse("2023-07-19"), 5000L, "영어", 1234));
        bookList.put(99L, new EBook("바이오 혁명", "매일경제", Long.parseLong("8791169021424"), LocalDate.parse("2008-05-17"), 1500L));
        bookList.put(98L, new EBook("탁류", "채만식", Long.parseLong("8791169021424"), LocalDate.parse("1974-05-28"), 1500L));
        bookList.put(1L, new Book("돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331795"), LocalDate.parse("2020-06-15")));
        bookList.put(5L, new Book("돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331795"), LocalDate.parse("2021-09-24")));
        bookList.put(6L, new Book("침묵의 퍼레이드", "히가시노 게이고", Long.parseLong("3211671290842"), LocalDate.parse("2022-02-14")));
        bookList.put(7L, new EBook("침묵의 퍼레이드", "히가시노 게이고", Long.parseLong("3211671290842"), LocalDate.parse("2022-02-14"),8000L));
        bookList.put(8L, new AudioBook("침묵의 퍼레이드", "히가시노 게이고", Long.parseLong("3211671290842"), LocalDate.parse("2022-02-14"), 8000L, "일본어", 45000));
    }
    @Override
    void interactWithUser() {
        while (true) {
            System.out.println("■■■■■■ 도서 관리 프로그램 ■■■■■■");
            System.out.println("(1) 도서 조회");
            System.out.println("(2) 도서 등록");
            System.out.println("(3) 도서 수정");
            System.out.println("(4) 도서 삭제");
            System.out.println("(q) 프로그램 종료");
            System.out.print("선택 >> ");
            String userInput = sc.nextLine();
            switch (userInput) {
                case "1":
                    // 조회
                    printAllBook();
                    break;
                case "2":
                    // 등록
                    addBook();
                    break;
                case "3":
                    // 수정
                    updateBook();
                    break;
                case "4":
                    // 삭제
                    removeBook();
                    break;
                case "q":
                    // 메소드를 종료
                    System.out.println("프로그램 종료!");
                    return;
            }
        }
    }

    @Override
    public void addBook() {
        System.out.println("등록 메서드 실행");
        System.out.println("등록할 책의 종류를 선택해 주세요");
        System.out.println("(1)Book");
        System.out.println("(2)EBook");
        System.out.println("(3)AudioBook");
        String InputNumber = sc.nextLine();
        if (InputNumber.equals("1")) {
            String[] bookInfo = new String[5];
            System.out.print("id: ");
            bookInfo[0] = sc.nextLine();
            System.out.print("제목: ");
            bookInfo[1] = sc.nextLine();
            System.out.print("저자: ");
            bookInfo[2] = sc.nextLine();
            System.out.print("isbn: ");
            bookInfo[3] = sc.nextLine();
            System.out.print("출판일(YYYY-MM-DD): ");
            bookInfo[4] = sc.nextLine();

            try {
                long IdErr = Long.parseLong(bookInfo[0]);
                long IsbnErr = Long.parseLong(bookInfo[3]);
                LocalDate LocalDateErr = LocalDate.parse(bookInfo[4]);
            } catch (NumberFormatException e) {
                System.out.println("id 혹은 isbn은 숫자만 입력 가능합니다" + e.getMessage());
                return;
            } catch (DateTimeParseException e) {
                System.out.println("입력된 날짜 형식이 틀렸습니다." + e.getMessage());
                return;
            }
            // book타입 저장
            Book book = new Book(Long.parseLong(bookInfo[0]),
                    bookInfo[1],
                    bookInfo[2],
                    Long.parseLong(bookInfo[3]),
                    LocalDate.parse(bookInfo[4]));
            bookList.put(Long.parseLong(bookInfo[0]), book);
        } else if (InputNumber.equals("2")) {
            String[] bookInfo = new String[6];
            System.out.print("id: ");
            bookInfo[0] = sc.nextLine();
            System.out.print("제목: ");
            bookInfo[1] = sc.nextLine();
            System.out.print("저자: ");
            bookInfo[2] = sc.nextLine();
            System.out.print("isbn: ");
            bookInfo[3] = sc.nextLine();
            System.out.print("출판일(YYYY-MM-DD): ");
            bookInfo[4] = sc.nextLine();
            System.out.print("파일크기(mb): ");
            bookInfo[5] = sc.nextLine();
            try {
                long IdErr = Long.parseLong(bookInfo[0]);
                long IsbnErr = Long.parseLong(bookInfo[3]);
                LocalDate LocalDateErr = LocalDate.parse(bookInfo[4]);
                long FileSizeErr = Long.parseLong(bookInfo[5]);
            } catch (NumberFormatException e) {
                System.out.println("id, isbn, 파일크기는 숫자만 입력 가능합니다" + e.getMessage());
                return;
            } catch (DateTimeParseException e) {
                System.out.println("입력된 날짜 형식이 틀렸습니다." + e.getMessage());
                return;
            }
            // Ebook타입 저장
            EBook Ebook = new EBook(Long.parseLong(bookInfo[0]),
                    bookInfo[1],
                    bookInfo[2],
                    Long.parseLong(bookInfo[3]),
                    LocalDate.parse(bookInfo[4]),
                    Long.parseLong(bookInfo[5]));
            bookList.put(Long.parseLong(bookInfo[0]), Ebook);
        } else if (InputNumber.equals("3")) {
            String[] bookInfo = new String[8];
            System.out.print("id: ");
            bookInfo[0] = sc.nextLine();
            System.out.print("제목: ");
            bookInfo[1] = sc.nextLine();
            System.out.print("저자: ");
            bookInfo[2] = sc.nextLine();
            System.out.print("isbn: ");
            bookInfo[3] = sc.nextLine();
            System.out.print("출판일(YYYY-MM-DD): ");
            bookInfo[4] = sc.nextLine();
            System.out.print("파일크기(mb): ");
            bookInfo[5] = sc.nextLine();
            System.out.print("재생언어: ");
            bookInfo[6] = sc.nextLine();
            System.out.print("재생시간(초): ");
            bookInfo[7] = sc.nextLine();
            try {
                long IdErr = Long.parseLong(bookInfo[0]);
                long IsbnErr = Long.parseLong(bookInfo[3]);
                LocalDate LocalDateErr = LocalDate.parse(bookInfo[4]);
                long FileSizeErr = Long.parseLong(bookInfo[5]);
                Integer PlayTimeErr = Integer.parseInt(bookInfo[7]);
            } catch (NumberFormatException e) {
                System.out.println("id,isbn,파일크기,재생시간은 숫자만 입력 가능합니다" + e.getMessage());
                return;
            } catch (DateTimeParseException e) {
                System.out.println("입력된 날짜 형식이 틀렸습니다." + e.getMessage());
                return;
            }
            // AudioBook타입 저장
            AudioBook audioBook = new AudioBook(Long.parseLong(bookInfo[0]),
                    bookInfo[1],
                    bookInfo[2],
                    Long.parseLong(bookInfo[3]),
                    LocalDate.parse(bookInfo[4]),
                    Long.parseLong(bookInfo[5]),
                    bookInfo[6],
                    Integer.parseInt(bookInfo[7]));
            bookList.put(Long.parseLong(bookInfo[0]), audioBook);
        } else {
            System.out.println("없는 번호 입니다.");
        }
    }
    @Override
    public void printAllBook() {
        System.out.println("등록할 책의 종류를 선택해 주세요");
        System.out.println("(1)전체 조회");
        System.out.println("(2)책 제목으로 조회");
        System.out.println("(3)책 제목 사전순으로 조회");
        System.out.println("(4)출간일 기간으로 조회");
        System.out.println("(5)출간일 순으로 조회(오름차순)");
        System.out.println("(6)중복 책 찾기");
        String InputNumber = sc.nextLine();
        if (InputNumber.equals("1")) {
            Set<Long> keyset = bookList.keySet();
            Iterator<Long> iterator = keyset.iterator();
            while (iterator.hasNext()) {
                Long key = iterator.next();
                //키를 통하여 북타입 밸류에 접근
                Book bookval = bookList.get(key);
                System.out.println(bookval.toString(key));
            }
        } else if (InputNumber.equals("2")) {
            System.out.println("책 제목을 입력해 주세요(부분만 입력 가능) ");
            System.out.println("ex) " + "'해리'를 입력하시면 " + "해리란 단어가 포함된 책을 조회합니다.");
            System.out.println("아무것도 입력하지 않을 경우 전체 조회합니다.");
            System.out.print("책 제목(부분만 입력 가능): ");
            String InputName = sc.nextLine();

            Set<Long> keyset = bookList.keySet();
            Iterator<Long> iterator = keyset.iterator();
            while (iterator.hasNext()) {
                Long key = iterator.next();
                Book bookval = bookList.get(key);
                if (bookval.getName().contains(InputName)) {
                    System.out.println(bookval.toString(key));
                }
            }
        } else if (InputNumber.equals("3")) {
            //HashMap bookList를 HashMap map에 저장(복사)
            HashMap<Long, Book> map = bookList;

            // 맵의 키값으로 새로운 리스트 keys를 생성
            List<Long> keys = new ArrayList<>(map.keySet());
            //sout(keys)할 경우, 키 값이 출력됨 ex) [1,2,98 ~~~~]

            //Collections.sort를 통해 정렬한다
            //리스트 keys에 맞추어 각 요소 1,2의 책 제목을 비교
            //브레이크 포인트를 걸 경우 책 제목에 맞추어 키값이정렬됨
            Collections.sort(keys, (v1, v2) -> (map.get(v1).getName().compareTo(map.get(v2).getName())));
            //sout(keys)를 통해 정렬 여부확인

            //문자순으로 정렬된 키값에 맞추어 키 전체 순회
            for(Long key : keys){
                //정렬된 키값에따라 새로 bookval에 담음
                Book bookval = bookList.get(key);
                //정렬된 bookval에 재정의된 toString을 사용하여 출력
                System.out.println(bookval.toString(key));
            }
        } else if (InputNumber.equals("4")) {
            System.out.println("시작일을 입력해 주세요 :");
            String StartDate = sc.nextLine();
            System.out.println("종료일을 입력해 주세요 :");
            String EndDate = sc.nextLine();

            Set<Long> keyset = bookList.keySet();
            Iterator<Long> iterator = keyset.iterator();
            while (iterator.hasNext()) {
                Long key = iterator.next();
                Book bookval = bookList.get(key);
                if (bookval.getPublishedDate().isBefore(LocalDate.parse(EndDate)) && bookval.getPublishedDate().isAfter(LocalDate.parse(StartDate))) {
                    System.out.println(bookval.toString(key));
                }
            }
        } else if (InputNumber.equals("5")) {
            HashMap<Long, Book> map = bookList;
            List<Long> keys = new ArrayList<>(map.keySet());
            //오름차순이므로 3번 재활용함 판단하는 걸 출간일순으로만 바꿔줌
            Collections.sort(keys, (v1, v2) -> (map.get(v1).getPublishedDate().compareTo(map.get(v2).getPublishedDate())));

            for(Long key : keys){
                Book bookval = bookList.get(key);
                System.out.println(bookval.toString(key));
            }
        } else if (InputNumber.equals("6")) {
            //중복 몇번 발생하는가 체크용
            int count = 0;
            //하나의 데이터가 전체를 순회하며 중복이 있는가 체크
            //있다면 count를 1씩 늘리며 그 내용을 출력

            HashMap<Long, Book> map = bookList;
            List<Long> keys = new ArrayList<>(map.keySet());
            Set<Long> keyset = bookList.keySet();
            Iterator<Long> iterator = keyset.iterator();
            //현재 문제점
            //다른 타입을 동등하다고 하는듯? 키 6,7,8은 데이터만 같고 전부 다른 타입임.
            //아래 요구사항을 벗어남
            // **Book, EBook, AudioBook**은 상호 간 동등 관계가 성립되지 않도록 합니다.

            for(Long key : keys) {
                Book bookval = bookList.get(key);
                while (iterator.hasNext()) {
                    Long itKey = iterator.next();
                    Book bookval1 = bookList.get(itKey);
                    //키 값을 받은 bookval이 반복자로 순회하는 bookval1의 요소 하나씩을 돌아가며 비교
                    if (bookval.equals(bookval1) && !(key.equals(itKey))) {
                        //이 조건문을 추가하면 키6,7,8을 같다고 하지 않음 왜??????????
                        if(bookval1.equals(bookval) && !(itKey.equals(key))) {
                            System.out.println("------ 중복 도서(제목,저자,isbn이 같습니다.) ------");
                            System.out.println(bookval.toString(key));
                            System.out.println(bookval1.toString(itKey));
                            count++;
                        }
                    }
                }
                //whilea문을 탈출하면서 반복자 초기화 > 여기서 초기화 시키지 않으면 다음 키에서 while문을 돌때 반복자는 이미 꽉찬상태
                iterator = keyset.iterator();
            }
            //나누기 2 > 1과 5를 비교해서 동일하여 ++되었고, 5와 1이 비교되어 동일하기에 ++ 됨. 중첩을 제거하고자 나눠줌
            System.out.println("중복 도서 개수 : " + count / 2);
        } else {
            System.out.println("잘못된 조회 번호 입니다.");
        }
    }
    @Override
    public void updateBook() {
        System.out.println("수정 메서드 실행");
        System.out.print("수정할 도서번호를 입력해주세요: ");
        String id = sc.nextLine();
        try {
            long IdErr = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("id는 숫자만 입력 가능합니다" + e.getMessage());
            return;
        }
        Book book = findBook(Long.parseLong(id));
//        책이 존재하는 패턴 아래로 if문을 옮길경우 항상 false > 값이 들어가 버려서 그런듯?
        if (book == null) {
            System.out.println("입력하신 책을 찾을 수 없습니다.");
            return;
        }
        // 책이 존재할 때
        String[] bookInfo = new String[8];
        bookInfo[0] = id;
        System.out.println("[수정 정보를 입력해주세요]");
        System.out.print("제목: ");
        bookInfo[1] = sc.nextLine();
        System.out.print("저자: ");
        bookInfo[2] = sc.nextLine();
        System.out.print("isbn: ");
        bookInfo[3] = sc.nextLine();
        System.out.print("출판일(YYYY-MM-DD): ");
        bookInfo[4] = sc.nextLine();
        try {
            long IdErr = Long.parseLong(bookInfo[0]);
            long IsbnErr = Long.parseLong(bookInfo[3]);
            LocalDate LocalDateErr = LocalDate.parse(bookInfo[4]);
        } catch (NumberFormatException e) {
            System.out.println("id 혹은 isbn은 숫자만 입력 가능합니다" + e.getMessage());
            return;
        } catch (DateTimeParseException e) {
            System.out.println("입력된 날짜 형식이 틀렸습니다." + e.getMessage());
            return;
        }
        book.setName(bookInfo[1]);
        book.setAuthor(bookInfo[2]);
        book.setIsbn(Long.parseLong(bookInfo[3]));
        book.setPublishedDate(LocalDate.parse(bookInfo[4]));
        bookList.replace(Long.parseLong(id), book);
        //도서 조회와 동일. 북타입,이북타입,오디오북타입 비교하여 새로 입력받은 값 삽입
        if (book instanceof EBook) {
            System.out.print("파일크기(mb): ");
            bookInfo[5] = sc.nextLine();
            try {
                long FileSizeErr = Long.parseLong(bookInfo[5]);
            } catch (NumberFormatException e) {
                System.out.println("파일크기는 숫자만 입력 가능합니다." + e.getMessage());
                return;
            }
            ((EBook) book).setFileSize(Long.parseLong(bookInfo[5]));
            bookList.replace(Long.parseLong(id),book);
        } else if (book instanceof AudioBook) {
            System.out.print("파일크기(mb): ");
            bookInfo[5] = sc.nextLine();
            try {
                long FileSizeErr = Long.parseLong(bookInfo[5]);
            } catch (NumberFormatException e) {
                System.out.println("파일크기는 숫자만 입력 가능합니다." + e.getMessage());
                return;
            }
            ((AudioBook) book).setFileSize(Long.parseLong(bookInfo[5]));
            System.out.print("재생언어: ");
            bookInfo[6] = sc.nextLine();
            ((AudioBook) book).setLanguage(bookInfo[6]);
            System.out.print("재생시간(초): ");
            bookInfo[7] = sc.nextLine();
            try {
                long PlayTimeErr = Long.parseLong(bookInfo[7]);
            } catch (NumberFormatException e) {
                System.out.println("재생시간은 숫자만 입력 가능합니다." + e.getMessage());
                return;
            }
            ((AudioBook) book).setPlayTime(Integer.parseInt(bookInfo[7]));
            bookList.replace(Long.parseLong(id), book);
        }
    }
    @Override
    public void removeBook() {
        System.out.println("삭제 메서드 실행");
        System.out.println("삭제할 도서번호를 입력해주세요.");
        System.out.println("삭제할 도서 번호가 없는 경우, 관리 프로그램으로 돌아갑니다.");
        System.out.print("삭제할 도서 번호: ");
        String id = sc.nextLine();
        try {
            long IdErr = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("번호는 숫자 형식입니다." + e.getMessage());
            return;
        }
        Set<Long> keyset = bookList.keySet();
        Iterator<Long> iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Long key = iterator.next();
            if (key == Long.parseLong(id)) {
                bookList.remove(Long.parseLong(id));
                System.out.println("삭제가 완료 되었습니다. 해당 도서 번호는 : " + id + "입니다." );
                break;
                }
            }
        }
    public Book findBook(long id) {
        Set<Long> keyset = bookList.keySet();
        Iterator<Long> iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Long key = iterator.next();
            if (key == id) {
                return bookList.get(id);
            }
        }
        return null;
    }
}


