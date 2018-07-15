package Lesson4.Task3;

public class MainClass {
    public static void main(String[] args) {
        MFU mfu = new MFU();
        new Thread(()->{mfu.print("Doc-1", 5);}).start();
        new Thread(()->{mfu.scann("Doc-2", 5);}).start();
        new Thread(()->{mfu.scann("Doc-3", 5);}).start();
        new Thread(()->{mfu.print("Doc-4", 5);}).start();
        new Thread(()->{mfu.print("Doc-5", 5);}).start();
        new Thread(()->{mfu.scann("Doc-1", 5);}).start();
    }
}
