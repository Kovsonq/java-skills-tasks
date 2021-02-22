package course.thread.race;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tunnel extends Stage {
    public Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + this.length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                log.info(c.getName() + " готовится к этапу(ждет): " +
                        description);
                log.info(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info(c.getName() + " закончил этап: " +
                        description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
