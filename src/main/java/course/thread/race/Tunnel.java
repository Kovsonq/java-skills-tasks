package course.thread.race;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

@Slf4j
public class Tunnel extends Stage {
    private final Semaphore semaphore;

    public Tunnel(int length) {
        this.semaphore = new Semaphore(RaceTest.CARS_COUNT / 2);
        this.length = length;
        this.description = "Тоннель " + this.length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            if (!semaphore.tryAcquire()){
                log.info(c.getName() + " готовится к этапу(ждет): " +
                        description);
                semaphore.acquire();
            }
            log.info(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000L);
            log.info(c.getName() + " закончил этап: " +
                    description);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}

