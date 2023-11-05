package base;

public class Execute {
    static BookManager bm5 = new BM5();
    public static void main(String[] args) {
        bm5.init();
        bm5.interactWithUser();
    }
}