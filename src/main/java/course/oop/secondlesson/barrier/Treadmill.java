package course.oop.secondlesson.barrier;

import course.oop.secondlesson.movement.Participant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Treadmill extends Barrier {
    private int treadmillLength;

    public Treadmill(int treadmillLength) {
        this.barrierType = "Treadmill";
        this.treadmillLength = treadmillLength;
    }

    @Override
    public boolean contest(Participant participant) {
        if (participant.run(treadmillLength)) {
            log.info("{} did task", participant);
            return true;
        } else {
            log.info("{} didn't do this", participant);
            return false;
        }
    }
}
