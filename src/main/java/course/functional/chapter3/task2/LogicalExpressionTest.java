package course.functional.chapter3.task2;


import java.util.function.Predicate;

public class LogicalExpressionTest {
    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = x -> x < 100 || x % 2 != 0;
        System.out.println(Predicate.not(integerPredicate).and(x -> x > 20).test(102));
    }
}
