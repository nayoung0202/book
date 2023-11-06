package base;

import static base.BM5.write;

public class AutoSaveThread extends Thread{
    public void save() {
        String filePath = "C:/Temp/books.backup.txt";
        System.out.println("책 목록이 자동 저장 되었습니다.");
        System.out.println("저장 디렉토리 : " + filePath);
        try {
            write(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                //10000 = 10초
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                break;
            }
            save();
        }
    }
}
