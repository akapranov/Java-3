package Lesson4.Task3;

public class MFU {
    Object printLock = new Object();
    Object scannLock = new Object();
    public void print(String doc, int n){
        synchronized (printLock){
            System.out.printf("Begin: %s\n", doc);
            for (int i = 0; i < n; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Print page #%d\n", i);
            }
            System.out.printf("End of %s\n", doc);
        }
    }
}
