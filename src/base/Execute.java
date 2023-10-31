package base;
import java.time.LocalDate;
import java.util.Scanner;

public class Execute {
    // 사용자 입력을 받기 위한 스캐너 객체
    static Scanner sc = new Scanner(System.in);
    static BM bm = new BM();
    public static void main(String[] args) {

        while (true) {
            System.out.println("■■■■■■ 도서 관리 프로그램 ■■■■■■");
            System.out.println("(1) 도서 조회");
            System.out.println("(2) 도서 등록");
            System.out.println("(3) 도서 수정");
            System.out.println("(4) 도서 삭제");
            System.out.print("선택 >> ");
            String userInput = sc.nextLine();

            switch (userInput) {
                case "1":
                    // 조회 함수 호출
                    printAllBook();
                    break;
                case "2":
                    // 도서 등록 함수 호출
                    addBook();
                    break;
                case "3":
                    // 수정
                    updateBook();
                    break;
                case "4":
                    // 삭제
                    deleteBook();
                    break;
                case "q":
                    System.out.println("프로그램 종료!");
                    return; // 메소드를 종료
            }

        }
    }

    private static void deleteBook() {
        System.out.println("삭제 메서드 실행");
        System.out.print("삭제할 번호를 입력해 주세요: ");
        String id = sc.nextLine();

        Book book = new Book(Long.parseLong(id));
        bm.removeBook(book);
    }

    private static void updateBook() {
        System.out.println("수정 메서드 실행");
        System.out.print("수정할 도서번호를 입력해 주세요: ");
        String id = sc.nextLine();
        System.out.println("[수정 정보를 입력해 주세요]");
        System.out.print("제목: ");
        String name = sc.nextLine();
        System.out.print("저자: ");
        String author = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("출판일: ");
        String publishDate = sc.nextLine();
        Book book = new Book(Long.parseLong(id),
                name,
                author,
                Long.parseLong(isbn),
                LocalDate.parse(publishDate));
        bm.updateBook(book);
    }

    private static void addBook() {
        System.out.println("등록 메서드 실행");
        System.out.print("도서번호를 입력해주세요." + "(유일한 번호) >>");
        String id = sc.nextLine();
        System.out.print("도서명을 입력해주세요. >>");
        String name = sc.nextLine();
        System.out.print("저자명을 입력해주세요. >>");
        String author = sc.nextLine();
        System.out.print("ISBN을 입력해주세요. >>");
        String isbn = sc.nextLine();
        System.out.print("출간일을 입력해주세요. (YYYY-MM-DD형식) >>");
        String publishDate = sc.nextLine();

        Book book = new Book(Long.parseLong(id),
                name,
                author,
                Long.parseLong(isbn),
                LocalDate.parse(publishDate));

        bm.addBook(book);
    }
    private static void printAllBook() {
        System.out.println("조회 메서드 실행");
        bm.printAllBook();
    }
}