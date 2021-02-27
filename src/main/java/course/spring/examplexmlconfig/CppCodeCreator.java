package course.spring.examplexmlconfig;

public class CppCodeCreator implements CodeCreator {
    ClassNameGenerator classNameGenerator;

    public CppCodeCreator(ClassNameGenerator classNameGenerator) {
        this.classNameGenerator = classNameGenerator;
    }

    @Override
    public String getClassExample() {
        return "public class " + classNameGenerator.generateClassName()  + " {\n\n}";
    }

}
