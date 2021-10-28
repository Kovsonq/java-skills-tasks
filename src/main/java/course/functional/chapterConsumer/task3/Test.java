package course.functional.chapterConsumer.task3;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class Test {
    private static final String[] strings = new String[10];

    public static void main(String[] args) {
        BiConsumer<String, Integer> putString = (x,y) -> strings[y] = x;

        putString.accept("Last element", 9);
        putString.accept("First element", 0);
        putString.accept("middle element", 4);

        System.out.println(Arrays.toString(strings));
    }
}
