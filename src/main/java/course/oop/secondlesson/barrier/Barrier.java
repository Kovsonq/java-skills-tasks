package course.oop.secondlesson.barrier;

import course.oop.secondlesson.movement.Participant;

public abstract class Barrier {
    String barrierType;
    public abstract boolean contest(Participant participant);
}
