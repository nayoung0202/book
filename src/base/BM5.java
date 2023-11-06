package base;
import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BM5 extends BookManager {
    //hashmap,arraylist 양쪽에 대응하기 위해 여기서 일부 수정해야함
    //양쪽에 대응하는지 테스트 하기 위해서는 new HashMapRepo 를 ArrayListRepo 로 변경
    private static BookRepository bookList = new HashMapRepo();
    static Scanner sc = new Scanner(System.in);
    @Override
    void init() {
        //초기 파일 읽어들이기로 변경
        try {
            read();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //기존 사전 데이터
//        bookList.addBook(3L, new Book(3L,"부자아빠 가난한아빠", "로버트 키요사키", Long.parseLong("5791144331796"), LocalDate.parse("1999-02-15")));
//        bookList.addBook(20L, new AudioBook(20L,"산마처럼 비웃는 것", "미쓰다 신조", Long.parseLong("0211129850369"), LocalDate.parse("2008-01-24"), 7500L, "일본어", 9999));
//        bookList.addBook(2L, new EBook(2L,"K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2023-02-20"), 1000L));
//        bookList.addBook(11L, new EBook(11L,"k 배터리 레볼루션", "박순자", Long.parseLong("9791191521221"), LocalDate.parse("2017-08-02"), 1000L));
//        bookList.addBook(4L, new AudioBook(4L,"위기의 역사", "오건영", Long.parseLong("7711123000360"), LocalDate.parse("2023-07-19"), 5000L, "영어", 1234));
//        bookList.addBook(98L, new EBook(98L,"탁류", "채만식", Long.parseLong("8791169021424"), LocalDate.parse("1974-05-28"), 1500L));
//        bookList.addBook(1L, new Book(1L,"돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331795"), LocalDate.parse("2020-06-15")));
//        bookList.addBook(5L, new Book(5L,"돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331795"), LocalDate.parse("2021-09-24")));
//        bookList.addBook(6L, new Book(6L,"침묵의 퍼레이드", "히가시노 게이고", Long.parseLong("3211671290842"), LocalDate.parse("2022-02-14")));
//        bookList.addBook(7L, new EBook(7L,"침묵의 퍼레이드", "히가시노 게이고", Long.parseLong("3211671290842"), LocalDate.parse("2022-02-14"),8000L));
//        bookList.addBook(8L, new AudioBook(8L,"침묵의 퍼레이드", "히가시노 게이고", Long.parseLong("3211671290842"), LocalDate.parse("2022-02-14"), 8000L, "일본어", 45000));
    }
    //파일 쓰기
   public static void write(String filePath) throws Exception {
       BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
       List<Book> bookList1 = bookList.getBooks();

       for(Book bookval : bookList1) {
           writer.write(bookval.toString().substring(1, bookval.toString().length()-1) + "\n");
       }
       writer.flush();
       writer.close();
    }
    //파일 읽기
    public void read() throws Exception {
        String filePath = "C:/Temp/books.txt";
        //아래로 하면 UTF-8 지정 필요없음 왜?? > 몰루?
        //파일의 내용을 읽어들일 BufferReader 객체 생성
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
            //파일을 한줄씩 읽어간다
            while ((line = reader.readLine()) != null) {
                // ","로 split하여 배열에 저장
                String[] writeStr = line.split(",");
                //각 책정보를 저장한다.
                if(writeStr.length == 5) {
                    //if문에서 판별수단이 마땅치 않음 > 왜? 책 추가에서는 book인지 ebook인지 알지만, 읽을때는 정보가 없어서 모름.
                    //구분자로 쪼개 데이터 확인, 길이 비교 등을 하고 읽은것을  book,ebook 객체등으로 생성하여 추가.
                    Book book = new Book(Long.parseLong(writeStr[0]),
                            writeStr[1],
                            writeStr[2],
                            Long.parseLong(writeStr[3]),
                            LocalDate.parse(writeStr[4]));
                    bookList.addBook(Long.parseLong(writeStr[0]), book);
                }
                if(writeStr.length == 6 ) {
                    EBook Ebook = new EBook(Long.parseLong(writeStr[0]),
                            writeStr[1],
                            writeStr[2],
                            Long.parseLong(writeStr[3]),
                            LocalDate.parse(writeStr[4]),
                            Long.parseLong(writeStr[5].substring(0,writeStr[5].length()-2)));
                    bookList.addBook(Long.parseLong(writeStr[0]),Ebook);
                } else if (writeStr.length ==8) {
                    AudioBook audioBook = new AudioBook(Long.parseLong(writeStr[0]),
                            writeStr[1],
                            writeStr[2],
                            Long.parseLong(writeStr[3]),
                            LocalDate.parse(writeStr[4]),
                            Long.parseLong(writeStr[5].substring(0,writeStr[5].length()-2)),
                            writeStr[6],
                            Integer.parseInt(writeStr[7].substring(0,writeStr[7].length()-1)));
                    bookList.addBook(Long.parseLong(writeStr[0]),audioBook);
                }
            }
            reader.close();
        }
    @Override
    void interactWithUser() {
        while (true) {
//            AutoSaveThread autoSaveThread = new AutoSaveThread();
//            autoSaveThread.start();
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
    //인터페이스 addBook 재정의
    public void addBook() {
        String filePath = "C:/Temp/books.txt";
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
            bookList.addBook(Long.parseLong(bookInfo[0]), book);
            try {
                write(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
            bookList.addBook(Long.parseLong(bookInfo[0]), Ebook);
            try {
                write(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
            bookList.addBook(Long.parseLong(bookInfo[0]), audioBook);
            try {
                write(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
            List<Book> bookList1 = bookList.getBooks();
            for(Book bookval : bookList1){
                    System.out.println(bookval);
            }
        } else if (InputNumber.equals("2")) {
            System.out.println("책 제목을 입력해 주세요(부분만 입력 가능) ");
            System.out.println("ex) " + "'해리'를 입력하시면 " + "해리란 단어가 포함된 책을 조회합니다.");
            System.out.println("아무것도 입력하지 않을 경우 전체 조회합니다.");
            System.out.print("책 제목(부분만 입력 가능): ");
            String InputName = sc.nextLine();
            //HashMap,arrayList 인터페이스 재정의 메소드 getBooks 사용
            //k,K 소문자 대문자 구분이 안되어서 toLowerCase 추가
            List<Book> bookList1 = bookList.getBooks();
            for(Book bookval : bookList1){
                if(bookval.getName().toLowerCase().contains(InputName)){
                    System.out.println(bookval);
                }
            }
        } else if (InputNumber.equals("3")) {
            //HashMap,arrayList 인터페이스 재정의 메소드 getBooks 사용
            //람다식 대체할 수 있다고 뜨는데 BM4에서도 문제는 없었음...  걍 compareTo 그대로 사용
            List<Book> bookList1 = bookList.getBooks();
            bookList1.sort((o1, o2) -> o1.getName().toLowerCase().compareTo(o2.getName()));
            for (Book bookval: bookList1){
                System.out.println(bookval.toString());
            }
        } else if (InputNumber.equals("4")) {
            System.out.println("시작일을 입력해 주세요 :");
            String StartDate = sc.nextLine();
            System.out.println("종료일을 입력해 주세요 :");
            String EndDate = sc.nextLine();
            try{
                LocalDate StartDateErr = LocalDate.parse(StartDate);
                LocalDate EndDateErr = LocalDate.parse(EndDate);
            } catch(DateTimeParseException e) {
                System.out.println("입력된 날짜 형식이 틀렸습니다." + e.getMessage());
                return;
            }
            //HashMap,arrayList 인터페이스 재정의 메소드 getBooks 사용
            //조건문은 재사용
            List<Book> bookList1 = bookList.getBooks();
            for(Book bookval : bookList1){
                if(bookval.getPublishedDate().isBefore(LocalDate.parse(EndDate)) &&
                        bookval.getPublishedDate().isAfter(LocalDate.parse(StartDate))){
                    System.out.println(bookval);
                }
            }
        } else if (InputNumber.equals("5")) {
            //3번 재활용
            List<Book> bookList1 = bookList.getBooks();
            bookList1.sort((o1, o2) -> o1.getPublishedDate().compareTo(o2.getPublishedDate()));
            for (Book bookval: bookList1){
                System.out.println(bookval.toString());
            }
        } else if (InputNumber.equals("6")) {
            bookList.sameBooks();
        } else {
            System.out.println("잘못된 조회 번호 입니다.");
        }
    }
    @Override
    public void updateBook() {
        String filePath = "C:/Temp/books.txt";
        //updateBook을 인터페이스에 추가후 구현객체에서 재정의
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
            System.out.println("수정할 도서 정보가 없습니다. 다시 확인해 주십시오.");
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
        bookList.updateBook(Long.parseLong(id), book);
        try {
            write(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
            bookList.updateBook(Long.parseLong(id),book);
            try {
                write(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
            bookList.updateBook(Long.parseLong(id), book);
            try {
                write(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void removeBook() {
        String filePath = "C:/Temp/books.txt";
        System.out.println("삭제 메서드 실행");
        System.out.println("삭제할 도서번호를 입력해주세요.");
        System.out.print("삭제할 도서 번호: ");
        String id = sc.nextLine();
        try {
            long IdErr = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("번호는 숫자 형식입니다." + e.getMessage());
            return;
        }
        //구현객체 재정의
        bookList.removeBook(Long.parseLong(id));
        try {
            write(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Book findBook(Long id) {
        if(id != null){
            return bookList.getBook(id);
        } else {
            return null;
        }
    }
}
