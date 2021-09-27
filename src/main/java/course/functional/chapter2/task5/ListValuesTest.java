package course.functional.chapter2.task5;

import course.functional.chapter1.task6.ListValues;

public class ListValuesTest {

    public static void main(String[] args) {

        ListValues typicalCount = (price, year, distanceMinus) -> price - (year * ListValues.yearMinus) -
                (((int)distanceMinus/ ListValues.distanceThreshold) * ListValues.distanceMinus);

        ListValues sportCount = (price, year, distanceMinus) -> price + (year * ListValues.yearVintagePlus);

        System.out.println(typicalCount.getPrice(15000, 4, 20400));
        System.out.println(sportCount.getPrice(20000, 3, 15000));

    }

}
