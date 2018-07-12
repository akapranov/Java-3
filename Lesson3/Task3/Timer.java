package Lesson3.Task3;

public class Timer {

    static long t;

    static void start(){
        t = System.currentTimeMillis();
    }

    static void stopAndPrint() {
        System.out.println("time: " + (System.currentTimeMillis() - t));
    }
}
