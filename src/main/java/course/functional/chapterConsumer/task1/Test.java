package course.functional.chapterConsumer.task1;

import java.util.function.Consumer;

public class Test {
    private static int initialValue = 0;

    public static void main(String[] args) {
        Consumer<Integer> add = x -> initialValue += x;
        add.andThen(x -> initialValue += 4)
                .andThen(x -> initialValue *= 7)
                .andThen(x -> System.out.println(initialValue))
                .accept(5);
    }
}
