package course.thread.race;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class RaceTest {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT + 1);

        log.info("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(30), new Road(40));

        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (new Random().nextInt(10)), cyclicBarrier);
            new Thread(cars[i]).start();
        }

        try {
            cyclicBarrier.await();
            log.info("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cyclicBarrier.await();
            cyclicBarrier.await();
            log.info("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

