package course.spring.examplexmlconfig;

public class JavaCodeCreator implements CodeCreator {
    ClassNameGenerator classNameGenerator;

    public void setClassNameGenerator(ClassNameGenerator classNameGenerator) {
        this.classNameGenerator = classNameGenerator;
    }

    @Override
    public String getClassExample() {
        return "public class " + classNameGenerator.generateClassName()  + " {\n\n}";
    }
}
