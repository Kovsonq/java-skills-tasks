package course.oop.secondlesson;

import course.oop.secondlesson.actor.Cat;
import course.oop.secondlesson.actor.Human;
import course.oop.secondlesson.barrier.Barrier;
import course.oop.secondlesson.barrier.Treadmill;
import course.oop.secondlesson.barrier.Wall;
import course.oop.secondlesson.movement.Participant;

import java.util.ArrayList;
import java.util.List;

public class TaskRunner {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Human(900, 2));
        participants.add(new Cat(1001, 4));

        List<Barrier> barriers = new ArrayList<>();
        barriers.add(new Wall(1));
        barriers.add(new Treadmill(600));
        barriers.add(new Treadmill(1000));
        barriers.add(new Wall(3));

        for (Participant participant : participants) {
            for (Barrier barrier : barriers) {
                if (!(barrier.contest(participant))) break;
            }
        }


    }
}
