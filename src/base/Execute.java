package base;

public class Execute {
    static BookManager bm5 = new BM5();
    public static void main(String[] args) throws Exception {
        bm5.init();
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.start();
        bm5.interactWithUser();
    }
}