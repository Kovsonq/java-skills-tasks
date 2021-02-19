package course.oop.firstlesson;

import course.oop.firstlesson.animal.Animal;
import course.oop.firstlesson.animal.Cat;
import course.oop.firstlesson.animal.Dog;
import course.oop.firstlesson.animal.Horse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainApp {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Barsik", 200),
                new Dog("Jack", 400, 400),
                new Horse("Dingo", 1500, 450)
        };

        for (Animal animal : animals) {
            animal.run(300);
            animal.swim(100);
        }

        log.info("Message {} ", Animal.getCounter());
        log.info("Message {} ", Animal.getCount());

    }
}
