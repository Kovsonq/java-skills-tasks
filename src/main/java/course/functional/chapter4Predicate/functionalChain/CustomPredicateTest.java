package course.functional.chapter4Predicate.functionalChain;

import java.util.function.Predicate;

public class CustomPredicateTest {

    public static void main(String[] args) {

        Predicate<String> stringPredicate = s -> s.length() == 5;

        System.out.println(stringPredicate.test("hello"));
        System.out.println(stringPredicate.negate().test("hello"));
        System.out.println(stringPredicate.and(x-> x.length() > 3).test("byby"));
        System.out.println(stringPredicate.or(x-> x.length() > 3).test("byby"));

        System.out.println(stringPredicate.and(Predicate.not(x -> x.length() > 3)).test("byby"));

        Predicate<String> stringPredicate1 = Predicate.isEqual("olivia");
        System.out.println(stringPredicate1.test("olivia"));


        Predicate<String> lengthGr4 = x -> x.length() > 4;
        Predicate<String> charOisA = x -> x.charAt(0) == 'a';

        System.out.println("------------null----------");
        try {
            System.out.println(lengthGr4.and(charOisA).test(null));
        } catch (NullPointerException e){
            System.out.println("Error");
        }

        Predicate<String> nullProtected = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 4;
            }
            @Override
            public Predicate<String> and(Predicate<? super String> other) {
                return x -> x == null ? false : test(x) && other.test(x);
            }
        };

        System.out.println("----------null protected----------");
        System.out.println(nullProtected.and(charOisA).test(null));
    }
}
