package base;

public class Execute {
    static BookManager bm4 = new BM4();
    public static void main(String[] args) {
        bm4.init();
        bm4.interactWithUser();
    }
}