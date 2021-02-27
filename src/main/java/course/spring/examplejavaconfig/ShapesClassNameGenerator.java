package course.spring.examplejavaconfig;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ShapesClassNameGenerator implements ClassNameGenerator {
    @Override
    public String generateClassName() {
        String[] classNames = {"Circle", "Square", "Triangle","Ellipse"};
        return classNames[(new Random().nextInt(4))];
    }
}
