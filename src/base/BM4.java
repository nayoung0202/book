package base;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

// BookManager를 구현하는 구현 객체
public class BM4 extends BookManager {
    private HashMap<Long, Book> bookList = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    @Override
    void init() {
        bookList.put(3L, new Book("부자아빠 가난한아빠", "로버트 키요사키", Long.parseLong("5791144331796"), LocalDate.parse("1999-02-15")));
        bookList.put(20L, new AudioBook("산마처럼 비웃는 것", "미쓰다 신조", Long.parseLong("0211129850369"), LocalDate.parse("2008-01-24"), 7500L, "일본어", 9999));
        bookList.put(1L, new Book("돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331795"), LocalDate.parse("2020-06-15")));
        bookList.put(2L, new EBook("K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2023-02-20"), 1000L));
        bookList.put(4L, new AudioBook("위기의 역사", "오건영", Long.parseLong("7711123000360"), LocalDate.parse("2023-07-19"), 5000L, "영어", 1234));
        bookList.put(99L, new EBook("바이오 혁명", "매일경제", Long.parseLong("8791169021424"), LocalDate.parse("2008-05-17"), 1500L));
        bookList.put(99L, new EBook("탁류", "매일신문", Long.parseLong("8791169021424"), LocalDate.parse("1974-05-28"), 1500L));
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

            String sortbook = "";
            Set<Long> keyset = bookList.keySet();
            Iterator<Long> iterator = keyset.iterator();
            while (iterator.hasNext()) {
                Long key = iterator.next();
                Book bookval = bookList.get(key);
                sortbook += bookval.toString(key);
            }
            System.out.println(sortbook);
            sortbook


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
            System.out.println("정렬관련 패스");
        } else if (InputNumber.equals("6")) {
            System.out.println("중복 찾기");
            int count = 0;
            Set<Long> keyset = bookList.keySet();
            Iterator<Long> iterator = keyset.iterator();
            while (iterator.hasNext()) {
                Long key = iterator.next();
                Book bookval = bookList.get(key);
                if (bookval.equals(bookList.values())) {
                    System.out.println("중복있음");
                    count++;
                }
            }
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
            //키를 통하여 북타입 밸류에 접근
            Book bookval = bookList.get(key);
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


