package Lesson4.Task3;

public class MFU {
    Object printLock = new Object();
    Object scannLock = new Object();

    public void print(String doc, int n){
        synchronized (printLock){
            System.out.printf("Begin printing: %s\n", doc);
            for (int i = 0; i < n; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Print page #%d\n", i);
            }
            System.out.printf("End of printing %s\n", doc);
        }
    }

    public void scann(String doc, int n){
        synchronized (scannLock){
            System.out.printf("Begin scanning: %s\n", doc);
            for (int i = 0; i < n; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Scann page #%d\n", i);
            }
            System.out.printf("End of scanning %s\n", doc);
        }
    }
}
