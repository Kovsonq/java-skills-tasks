package course.spring.examplejavaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JavaCodeCreator implements CodeCreator {

    ClassNameGenerator classNameGenerator;

    @Autowired
    @Qualifier("animalClassNameGenerator")
    public void setClassNameGenerator(ClassNameGenerator classNameGenerator) {
        this.classNameGenerator = classNameGenerator;
    }

    @Override
    public String getClassExample() {
        return "public class " + classNameGenerator.generateClassName() + " {\n\n}";
    }
}
