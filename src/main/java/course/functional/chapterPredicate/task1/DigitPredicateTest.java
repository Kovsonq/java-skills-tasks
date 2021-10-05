package course.functional.chapterPredicate.task1;

import java.util.function.Predicate;

public class DigitPredicateTest {
    public static void main(String[] args) {
        String forTest = "2342134233423423d";
        Predicate<Character> stringPredicate = s -> s. toString().matches("[A-z]");
        boolean result = true;

        for (int i = 0; i < forTest.length(); i++) {
            if (stringPredicate.test(forTest.charAt(i))){
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
