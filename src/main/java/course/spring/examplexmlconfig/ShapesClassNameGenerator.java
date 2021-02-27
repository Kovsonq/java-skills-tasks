package course.spring.examplexmlconfig;

import java.util.Random;

public class ShapesClassNameGenerator implements ClassNameGenerator {
    @Override
    public String generateClassName() {
        String[] classNames = {"Circle", "Square", "Triangle","Ellipse"};
        return classNames[(new Random().nextInt(4))];
    }
}
