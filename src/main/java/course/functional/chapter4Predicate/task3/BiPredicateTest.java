package course.functional.chapter4Predicate.task3;

import java.util.function.BiPredicate;

public class BiPredicateTest {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> predicate = (x, y) -> x > 2 && y < x;
        System.out.println(predicate.negate().test(3,3));
    }
}
