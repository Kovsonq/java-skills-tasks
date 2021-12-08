package course.functional.chapter6Funtion.task3;

import course.functional.chapter6Funtion.overall.Function;
import course.functional.chapter6Funtion.task1.A;
import course.functional.chapter6Funtion.task1.B;

public class TaskTreeTest {
    public static void main(String[] args) {
        Function<A, B> abFunction = a -> new B(a.getD(), a.getS(), String.valueOf(a.getI()));

        System.out.println(abFunction.andThen(x -> x.getA() + "%" + x.getB() + "%" + x.getC()).apply(new A(20.3, "Hi", 1)));
    }
}
