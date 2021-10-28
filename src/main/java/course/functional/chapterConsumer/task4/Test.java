package course.functional.chapterConsumer.task4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Test {
    private static final Map<String,String> dictionary = new HashMap<>();
    private static String result = "";

    public static void main(String[] args) {
        dictionary.put("First", "perviy pig");
        dictionary.put("Second", "vtoroi pig and check");
        dictionary.put("Third", "tretiy lost but won");
        dictionary.put("Fourth", "chetvertyi smth");
        dictionary.put("Fifth", "piatyi else not");
        dictionary.put("Sixth", "shestoi where are you");

        Consumer<String> addValue = x -> {
            if (x.length() == 5){
                var stringValues = dictionary.get(x).split(" ");
                result = result.concat(stringValues[0]).concat(", ");
            }
        };

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            addValue.accept(entry.getKey());
        }
        result = result.substring(0, result.length()-2);

        System.out.println(result);
    }
}
