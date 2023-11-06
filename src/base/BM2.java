//package base;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.logging.LoggingPermission;
//
//// BookManager를 구현하는 구현 객체
//public class BM2 extends BookManager {
//
//    private ArrayList<Book> bookList = new ArrayList<>();
//    static Scanner sc = new Scanner(System.in);
//
//    @Override
//    void init() {
//        bookList.add(new Book(1L, "돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331796"), LocalDate.parse("2020-06-15")));
//        bookList.add(new Book(2L,"K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2021-02-20")));
//        bookList.add(new Book(3L, "위기의 역사", "오건영", Long.parseLong("9791169850360"), LocalDate.parse("2019-07-19")));
//    }
//
//    @Override
//    void interactWithUser() {
//        while (true) {
//            System.out.println("■■■■■■ 도서 관리 프로그램 ■■■■■■");
//            System.out.println("(1) 도서 조회");
//            System.out.println("(2) 도서 등록");
//            System.out.println("(3) 도서 수정");
//            System.out.println("(4) 도서 삭제");
//            System.out.println("(q) 프로그램 종료");
//            System.out.print("선택 >> ");
//            String userInput = sc.nextLine();
//
//            switch (userInput) {
//                case "1":
//                    // 조회
//                    printAllBook();
//                    break;
//                case "2":
//                    // 등록
//                    addBook();
//                    break;
//                case "3":
//                    // 수정
//                    updateBook();
//                    break;
//                case "4":
//                    // 삭제
//                    removeBook();
//                    break;
//                case "q":
//                    // 메소드를 종료
//                    System.out.println("프로그램 종료!");
//                    return;
//            }
//        }
//    }
//    @Override
//    public void addBook() {
//        System.out.println("등록 메서드 실행");
//        // 1. 콘솔화면을 통해 사용자로부터 도서정보를 입력을 받는다.
//        // id, 제목, 저자, isbn, 출판일 (5가지) (v)
//        // 위의 정보로 책 객체를 생성한다. (v)
//        // 2. 도서를 등록한다.
//        // 사서를 통해 도서 저장 요청
//        System.out.println("등록할 책의 종류를 선택해 주세요");
//        System.out.println("(1)Book");
//        System.out.println("(2)EBook");
//        System.out.println("(3)AudioBook");
//        String InputNumber = sc.nextLine();
//        if (InputNumber.equals("1")) {
//            String[] bookInfo = new String[5];
//            System.out.print("id: ");
//            bookInfo[0] = sc.nextLine();
//            System.out.print("제목: ");
//            bookInfo[1] = sc.nextLine();
//            System.out.print("저자: ");
//            bookInfo[2] = sc.nextLine();
//            System.out.print("isbn: ");
//            bookInfo[3] = sc.nextLine();
//            System.out.print("출판일(YYYY-MM-DD): ");
//            bookInfo[4] = sc.nextLine();
//            // book타입 저장
//            Book book = new Book(Long.parseLong(bookInfo[0]),
//                    bookInfo[1],
//                    bookInfo[2],
//                    Long.parseLong(bookInfo[3]),
//                    LocalDate.parse(bookInfo[4]));
//            bookList.add(book);
//        } else if (InputNumber.equals("2")) {
//            String[] bookInfo = new String[6];
//            System.out.print("id: ");
//            bookInfo[0] = sc.nextLine();
//            System.out.print("제목: ");
//            bookInfo[1] = sc.nextLine();
//            System.out.print("저자: ");
//            bookInfo[2] = sc.nextLine();
//            System.out.print("isbn: ");
//            bookInfo[3] = sc.nextLine();
//            System.out.print("출판일(YYYY-MM-DD): ");
//            bookInfo[4] = sc.nextLine();
//            System.out.print("파일크기(mb): ");
//            bookInfo[5] = sc.nextLine();
//            // Ebook타입 저장
//            EBook Ebook = new EBook(Long.parseLong(bookInfo[0]),
//                    bookInfo[1],
//                    bookInfo[2],
//                    Long.parseLong(bookInfo[3]),
//                    LocalDate.parse(bookInfo[4]),
//                    Long.parseLong(bookInfo[5]));
//            bookList.add(Ebook);
//        } else if (InputNumber.equals("3")) {
//            String[] bookInfo = new String[8];
//            System.out.print("id: ");
//            bookInfo[0] = sc.nextLine();
//            System.out.print("제목: ");
//            bookInfo[1] = sc.nextLine();
//            System.out.print("저자: ");
//            bookInfo[2] = sc.nextLine();
//            System.out.print("isbn: ");
//            bookInfo[3] = sc.nextLine();
//            System.out.print("출판일(YYYY-MM-DD): ");
//            bookInfo[4] = sc.nextLine();
//            System.out.print("파일크기(mb): ");
//            bookInfo[5] = sc.nextLine();
//            System.out.print("재생언어: ");
//            bookInfo[6] = sc.nextLine();
//            System.out.print("재생시간(초): ");
//            bookInfo[7] = sc.nextLine();
//            // AudioBook타입 저장
//            AudioBook audioBook = new AudioBook(Long.parseLong(bookInfo[0]),
//                    bookInfo[1],
//                    bookInfo[2],
//                    Long.parseLong(bookInfo[3]),
//                    LocalDate.parse(bookInfo[4]),
//                    bookInfo[5],
//                    bookInfo[6],
//                    Integer.parseInt(bookInfo[7]));
//            bookList.add(audioBook);
//        } else {
//            System.out.println("없는 번호 입니다.");
//        }
//    }
//    @Override
//    public void printAllBook() {
//        for (Book book : bookList) {
//            //구분자 포함하여 출력
//            System.out.print("[");
//            System.out.print(book.getId());
//            System.out.print(", ");
//            System.out.print(book.getName());
//            System.out.print(", ");
//            System.out.print(book.getAuthor());
//            System.out.print(", ");
//            System.out.print(book.getIsbn());
//            System.out.print(", ");
//            System.out.print(book.getPublishedDate());
//            //클래스 비교후 종류에 따른 구분자 및 단위 출력
//            //init 메소드에서 미리 입력받은 3개의 값은 book타입으로 생성된 객체. 값 추가없이 도서 조회 할경우
//            //if문은 arrayList에 들어가 있는 데이터가 ebook타입으로 생성된 객체냐? > false
//            //else if문은 ebook타입이 아니라면 AudioBook 타입으로 생성된 객체냐? > false
//            //두개 다 해당하지 않을 경우 book타입이므로 추가 출력 없이 종료하며 for문으로 돌아감
//            //출력 확인 OK
//            if(book instanceof EBook){
//                System.out.print(", ");
//                System.out.print(((EBook)book).getFileSize() + "mb");
//            } else if(book instanceof AudioBook){
//                System.out.print(", ");
//                System.out.print(((AudioBook)book).getFileSize() + "mb");
//                System.out.print(", ");
//                System.out.print(((AudioBook)book).getLanguage());
//                System.out.print(", ");
//                System.out.print(((AudioBook)book).getPlayTime() + "초");
//            }
//            //if문 앞일경우 칸 안닫힘
//            System.out.print("]");
//            System.out.println();
//        }
//    }
//
//    @Override
//    public void updateBook() {
//        System.out.println("수정 메서드 실행");
//        // 1. 수정할 도서를 찾는다. (사서는 알 수 있다.) (v)
//        // 있으면 수정 가능
//        // 없으면 수정 불가
//        // 2. 수정할 도서가 있을 때:
//        // 새로운 입력 값 : 사용자로부터 입력받는다.
//        // 도서 정보(필드)를 바꾼다.
//
//        System.out.print("수정할 도서번호를 입력해주세요: ");
//        String id = sc.nextLine();
//        Book book = findBook(Long.parseLong(id));
//
//        //책이 존재하는 패턴 아래로 if문을 옮길경우 항상 false > 값이 들어가 버려서 그런듯?
//        if (book == null) {
//            System.out.println("입력하신 책을 찾을 수 없습니다.");
//            return;
//        }
//        // 책이 존재할 때
//        String[] bookInfo = new String[8];
//        bookInfo[0] = id;
//        System.out.println("[수정 정보를 입력해주세요]");
//        System.out.print("제목: ");
//        bookInfo[1] = sc.nextLine();
//        System.out.print("저자: ");
//        bookInfo[2] = sc.nextLine();
//        System.out.print("isbn: ");
//        bookInfo[3] = sc.nextLine();
//        System.out.print("출판일(YYYY-MM-DD): ");
//        bookInfo[4] = sc.nextLine();
//
//        book.setName(bookInfo[1]);
//        book.setAuthor(bookInfo[2]);
//        book.setIsbn(Long.parseLong(bookInfo[3]));
//        book.setPublishedDate(LocalDate.parse(bookInfo[4]));
//        //도서 조회와 동일. 북타입,이북타입,오디오북타입 비교하여 새로 입력받은 값 삽입
//        if(book instanceof EBook){
//            System.out.print("파일크기(mb): ");
//            bookInfo[5] = sc.nextLine();
//            ((EBook)book).setFileSize(Long.parseLong(bookInfo[5]));
//        } else if(book instanceof AudioBook){
//            System.out.print("파일크기(mb): ");
//            bookInfo[5] = sc.nextLine();
//            ((AudioBook)book).setFileSize(bookInfo[5]);
//            System.out.print("재생언어: ");
//            bookInfo[6] = sc.nextLine();
//            ((AudioBook)book).setLanguage(bookInfo[6]);
//            System.out.print("재생시간(초): ");
//            bookInfo[7] = sc.nextLine();
//            ((AudioBook)book).setPlayTime(Integer.parseInt(bookInfo[7]));
//        }
//    }
//    @Override
//    public void removeBook() {
//        System.out.println("삭제 메서드 실행");
//        // 1. 삭제할 도서를 찾는다.
//        // 없으면 삭제 불가
//        // 있으면 삭제 가능
//        // 2. 삭제할 도서가 있다면
//        // 사서한테 도서 삭제 요청
//        System.out.print("삭제할 도서번호를 입력해주세요: ");
//        String id = sc.nextLine();
//
//        Book book = findBook(Long.parseLong(id));
//        if (book == null) {
//            System.out.println("입력하신 책을 찾을 수 없습니다.");
//        }
//        bookList.remove(book);
//    }
//    public Book findBook(long id) {
//        for (Book book : bookList) {
//            if (id == book.getId()) {
//                return book;
//            }
//        }
//        // bookList를 다 돌았는데 해당 id의 도서를 못찾았다.
//        return null;
//    }
//}