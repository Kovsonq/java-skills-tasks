package course.functional.chapter1.task6;

@FunctionalInterface
public interface ListValues {
    double yearMinus = 1000;
    double distanceMinus = 500;
    double yearVintagePlus = 250;
    int distanceThreshold = 10000;

    double getPrice(double price, int year, double distanceMinus);
}
