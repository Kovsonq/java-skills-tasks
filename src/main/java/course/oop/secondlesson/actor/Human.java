package course.oop.secondlesson.actor;

import course.oop.secondlesson.movement.Participant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Human implements Participant {
    private int maxLengthOfDistance;
    private int maxHeightForJumping;

    public Human(int maxLengthOfDistance, int maxHeightForJumping) {
        this.maxLengthOfDistance = maxLengthOfDistance;
        this.maxHeightForJumping = maxHeightForJumping;
    }


    @Override
    public boolean jump(int height) {
        if (height < 0) {
            log.info("Incorrect value");
            return false;
        } else if (maxHeightForJumping > height) {
            log.info("I'm human and jumped throw wall " + height + " m");
            return true;
        } else {
            log.info("It's so much for me " + height + " m. I finished my trip.");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (distance < 0) {
            log.info("Incorrect value");
            return false;
        } else if (maxLengthOfDistance > distance) {
            log.info("I'm human run distance " + distance + " m");
            return true;
        } else {
            log.info("It's so much for me " + distance + " m. I finished my trip.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Human";
    }
}
