package course.functional.chapter4Predicate.task4;

import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PalindromeTest {
    public static void main(String[] args) {
        String palindrome = "olahalo";

        Predicate<String> predicate = s -> {
            int wordLength = s.split("").length-1;
            for (int i = 0, j = wordLength; i < wordLength/2; i++, j--) {
                if (s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
            return true;
        };
        System.out.println(predicate.test(palindrome.toLowerCase(Locale.ROOT)));

        System.out.println(IntStream.range(0, palindrome.length()/2)
                .noneMatch(i -> palindrome.charAt(i) != palindrome.charAt(palindrome.length() - i - 1)));
    }
}
