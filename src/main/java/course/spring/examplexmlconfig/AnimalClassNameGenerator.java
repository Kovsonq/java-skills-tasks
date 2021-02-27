package course.spring.examplexmlconfig;

import java.util.Random;

public class AnimalClassNameGenerator implements ClassNameGenerator {
    @Override
    public String generateClassName() {
        String[] classNames = {"Cat", "Dog", "Pig","Elephant"};
        return classNames[(new Random().nextInt(4))];
    }
}
