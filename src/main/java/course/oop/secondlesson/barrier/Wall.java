package course.oop.secondlesson.barrier;

import course.oop.secondlesson.movement.Participant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Wall extends Barrier {
    private int wallHeight;

    public Wall(int wallHeight) {
        this.barrierType = "Wall";
        this.wallHeight = wallHeight;
    }

    @Override
    public boolean contest(Participant participant) {
        if (participant.jump(wallHeight)) {
            log.info("{} did task", participant);
            return true;
        } else {
            log.info("{} didn't do this", participant.toString());
            return false;
        }
    }
}
