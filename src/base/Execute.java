package base;

public class Execute {
    static BookManager bm3 = new BM3();
    public static void main(String[] args) {
        bm3.init();
        bm3.interactWithUser();
    }
}