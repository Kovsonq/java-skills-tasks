package course.functional.chapter4Predicate.overall;

public class PredicateGenericTest {

    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = x -> x>2;
        Predicate<String> stringPredicate = s -> s.charAt(0) == 'H';

        result(integerPredicate, 3);
        result(stringPredicate, "H");
        result(y->y <3, 2);
        result(s-> s.charAt(0) == 'h', "h");
    }

    public static <X> void result(Predicate<X> p, X arg){
        if (p.test(arg)) {
            System.out.println("the predicate is true for " + arg);
        } else {
            System.out.println("the predicate is false for " + arg);
        }
    }
}
