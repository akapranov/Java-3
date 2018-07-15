package Lesson4.Task1;

public class MainClass {
    static volatile char str = 'A';

    public static void main(String[] args) {
        Object lock = new Object();

        class doYourJob implements Runnable{
            private char c;
            private char nextC;
            private int number = 5;

            public doYourJob(char c, char nextC) {
                this.c = c;
                this.nextC = nextC;
            }

            @Override
            public void run() {
                for (int i = 0; i < number; i++) {
                    synchronized (lock){
                        try {
                            while(str != c){
                                lock.wait();
                            }
                            System.out.print(c);
                            str = nextC;
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
        new Thread(new doYourJob('A', 'B')).start();
        new Thread (new doYourJob('B', 'C')).start();
        new Thread (new doYourJob('C', 'A')).start();
    }

}
