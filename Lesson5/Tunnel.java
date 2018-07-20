package Lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    final static int tunnelCapacity = MainClass.CARS_COUNT/2;
    Semaphore smf = new Semaphore(tunnelCapacity, true);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            smf.acquire();
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            smf.release();
            System.out.println(c.getName() + " закончил этап: " + description);
        }

    }
}

