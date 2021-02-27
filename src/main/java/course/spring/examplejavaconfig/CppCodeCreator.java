package course.spring.examplejavaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CppCodeCreator implements CodeCreator {

    ClassNameGenerator classNameGenerator;

    @Autowired
    public void setClassNameGenerator(ClassNameGenerator classNameGenerator) {
        this.classNameGenerator = classNameGenerator;
    }

    @Override
    public String getClassExample() {
        return "public class " + classNameGenerator.generateClassName()  + " {\n\n}";
    }

}
