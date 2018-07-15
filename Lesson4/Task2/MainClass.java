package Lesson4.Task2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainClass {
    public static void main(String[] args) {
        class TextWriter implements Runnable{
            private PrintWriter printWriter;
            private int x;

            public TextWriter(PrintWriter printWriter, int x) {
                this.printWriter = printWriter;
                this.x = x;
            }

            @Override
            public void run() {
                for (int i = 0; i < x; i++) {
                    try {
                        Thread.sleep(20);
                        printWriter.println(x);
                        printWriter.flush();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("src/Lesson4/Task2/example.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(new TextWriter(printWriter,10));
        Thread t2 = new Thread(new TextWriter(printWriter,11));
        Thread t3 = new Thread(new TextWriter(printWriter,12));

        try {
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
