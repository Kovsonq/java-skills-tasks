package course.functional.chapterPredicate.overall;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<Integer> predicate = x->x<9;
        System.out.println(predicate.test(10));

        Predicate<Integer> newPredicate = x-> x==6;

        result(newPredicate, 6);
        result(y->y == 5, 5);
    }

    public static void result(Predicate<Integer> p, Integer arg){
        if (p.test(arg)) {
            System.out.println("the predicate is true for " + arg);
        } else {
            System.out.println("the predicate is false for " + arg);
        }
    }
}
