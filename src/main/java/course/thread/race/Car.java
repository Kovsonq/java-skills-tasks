package course.thread.race;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Data
public class Car implements Runnable {
    private static int CARS_COUNT = 0;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cyclicBarrier;

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            log.info(this.name + " готовится");
            Thread.sleep(500 + (long) (new Random().nextInt(800)));
            log.info(this.name + " готов");
            cyclicBarrier.await();
            cyclicBarrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            if (atomicInteger.incrementAndGet() == 1){
                log.info(this.name + " - Win");
            }
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

