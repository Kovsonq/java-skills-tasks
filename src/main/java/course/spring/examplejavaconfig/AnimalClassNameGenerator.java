package course.spring.examplejavaconfig;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Primary
public class AnimalClassNameGenerator implements ClassNameGenerator {
    @Override
    public String generateClassName() {
        String[] classNames = {"Cat", "Dog", "Pig","Elephant"};
        return classNames[(new Random().nextInt(4))];
    }
}
