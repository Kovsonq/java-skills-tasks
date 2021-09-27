package course.functional.chapter2.task2;

import course.functional.chapter1.task2.Summer;

public class SummerTest {

    public static void main(String[] args) {

        Summer<Integer> sumInt = (x1, x2) -> x1 + x2;

        Summer<Double> dubSum = (x1, x2) -> x1 * x2;

        Summer<Long> longSum = (x1, x2) -> x1 + x2;

        System.out.println(sumInt.sum(2,3));
        System.out.println(dubSum.sum(2.0, 3.0));
        System.out.println(longSum.sum(2l,3l));
    }
}
