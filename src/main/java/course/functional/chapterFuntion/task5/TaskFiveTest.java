package course.functional.chapterFuntion.task5;

import course.functional.chapterFuntion.overall.Function;

import java.util.HashMap;
import java.util.Map;

public class TaskFiveTest {

    static Map<String, String> animalMap = Map.of(
            "dog","wolf descendant",
            "cat","feline with nine lives",
            "rat", "rodent with long tail");

    public static void main(String[] args) {

        Function<Map<String, String>, Map<String, String>> replacedMap = x -> {
            Map<String, String> replaced = new HashMap<>();
            for (Map.Entry<String, String> entry : x.entrySet()) {
                replaced.put(entry.getValue(), entry.getKey());
            }
            return replaced;
        };

        System.out.println(animalMap);
        System.out.println(replacedMap.apply(animalMap));

    }
}
