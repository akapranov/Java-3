package Lesson5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    static boolean x = true;
    private static int CARS_COUNT;
    static final CyclicBarrier cb = new CyclicBarrier(MainClass.CARS_COUNT);
    static { CARS_COUNT = 0;}
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            if(cb.getNumberWaiting() == MainClass.CARS_COUNT -1) System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if (i == race.getStages().size()-1 && cb.getNumberWaiting() == 0 && x){
                System.out.println("Участник #" + this.name + " WINN!!!");
                x = false;
            }
        }
        MainClass.countDownLatch.countDown();
    }

}
