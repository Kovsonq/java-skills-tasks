package course.functional.chapterFuntion.task1;

import course.functional.chapterFuntion.overall.Function;

public class TaskOneTest {

    public static void main(String[] args) {

        Function<A,B> abFunction = x -> new B(x.d, x.s, Integer.toString(x.i));
        Function<B,A> baFunction = x -> new A(x.a, x.b, Integer.parseInt(x.c));

        A aClass = new A(20.0, "Mary", 4);

        System.out.println(aClass);
        B bClass = abFunction.apply(aClass);
        System.out.println(bClass);
        A aClass2 = baFunction.apply(bClass);
        System.out.println(aClass2);
    }
}
