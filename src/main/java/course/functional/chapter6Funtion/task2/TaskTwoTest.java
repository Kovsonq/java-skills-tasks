package course.functional.chapter6Funtion.task2;

import course.functional.chapter6Funtion.overall.Function;

public class TaskTwoTest {

    public static <T extends C> Integer execute(T value){
        Function<T, Integer> iConverter = x-> x.first + x.second;
        return iConverter.apply(value);
    }

    public static void main(String[] args) {
        System.out.println(execute(new C(1,5)));
        System.out.println(execute(new D(4,5)));
        System.out.println(execute(new E(5,5)));
    }
}
