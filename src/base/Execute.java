package base;

public class Execute {
    static BookManager bm2 = new BM2();

    public static void main(String[] args) {
        bm2.init();
        bm2.interactWithUser();
    }
}