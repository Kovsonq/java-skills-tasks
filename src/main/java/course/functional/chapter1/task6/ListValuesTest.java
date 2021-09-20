package course.functional.chapter1.task6;

public class ListValuesTest {

    public static void main(String[] args) {

        ListValues typicalCount = new ListValues() {
            @Override
            public double getPrice(double price, int year, double distanceMinus) {
                return price - (year * ListValues.yearMinus) - (((int)distanceMinus/ListValues.distanceThreshold) * ListValues.distanceMinus);
            }
        };

        ListValues sportCount = new ListValues() {
            @Override
            public double getPrice(double price, int year, double distanceMinus) {
                return price + (year * ListValues.yearVintagePlus);
            }
        };

        System.out.println(typicalCount.getPrice(15000, 4, 20400));
        System.out.println(sportCount.getPrice(20000, 3, 15000));

    }

}
