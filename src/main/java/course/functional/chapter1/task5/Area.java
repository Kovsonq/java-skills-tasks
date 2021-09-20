package course.functional.chapter1.task5;

@FunctionalInterface
public interface Area {
    double PI = 3.14;

    double compute(double x1, double x2);

    default int numberOfSides(){
        return 4;
    }
}
